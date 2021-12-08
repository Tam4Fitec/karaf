package com.leguide.backoffice.karaf.dao.brands.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.exception.LoadDBException;
import com.leguide.backoffice.karaf.brands.common.exception.NotFoundException;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllBrandsFilters;
import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.brands.common.utils.enums.SearchBrandsTypeEnum;
import com.leguide.backoffice.karaf.dao.brands.IBrandsDAO;
import com.leguide.backoffice.karaf.dao.brands.adapters.IBrandAdapter;
import com.leguide.backoffice.karaf.dao.brands.adapters.impl.BrandAdapter;
import com.leguide.backoffice.karaf.dao.brands.cache.ICacheService;
import com.leguide.backoffice.karaf.dao.brands.cache.IdCacheKey;
import com.leguide.backoffice.karaf.dao.brands.cache.NameCacheKey;
import com.leguide.backoffice.karaf.dao.brands.cache.NormalizedNameCacheKey;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandAliasDTO;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandAliasDTO_;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandDTO;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandDTO_;

public final class BrandsDAOImpl extends AbstractDAO<BrandBO, BrandDTO> implements IBrandsDAO {

    private Logger logger = LoggerFactory.getLogger(BrandsDAOImpl.class);

    private IBrandAdapter adapter = new BrandAdapter();

    private EntityManager em;

    private DataSource dataSource;

    private final class BrandExtractor implements ResultSetExtractor<List<BrandDTO>> {

        public List<BrandDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, BrandDTO> brands = new HashMap<Long, BrandDTO>();

            while (rs.next()) {
                Long brandId = rs.getLong(1);
                BrandDTO brand = brands.get(brandId);
                if (brand == null) {
                    brand = new BrandDTO();
                    brand.setId(brandId);
                    brand.setName(rs.getString(2));
                    brand.setNormalizedName(rs.getString(3));
                    brand.setSeoName(rs.getString(4));
                    brand.setBlacklistedSem(rs.getBoolean(5));
                    brand.setBlacklistedSeo(rs.getBoolean(6));
                    brand.setActivationDate(rs.getDate(7));
                    brand.setBrandAliases(new HashSet<BrandAliasDTO>());
                    brands.put(brandId, brand);
                }

                // Alias
                if (rs.getMetaData().getColumnCount() > 8) {
                    if (rs.getLong(9) != 0) {
                        BrandAliasDTO alias = new BrandAliasDTO();
                        alias.setId(rs.getLong(9));
                        alias.setName(rs.getString(10));
                        alias.setActivationDate(rs.getDate(12));
                        alias.setNameNormalized(rs.getString(13));

                        brand.getBrandAliases().add(alias);
                    }
                }
            }
            return new ArrayList<BrandDTO>(brands.values());
        }
    }

    @Override
    public List<BrandBO> getAllBrands(GetAllBrandsFilters filters) {
        List<BrandBO> result = new ArrayList<BrandBO>();
        List<BrandDTO> tmpRes = this.getAllBrandsQuery(filters);
        for (BrandDTO item : tmpRes) {
            result.add(this.adapter.adapt(item, filters.getAddAliases()));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<BrandDTO> getAllBrandsQuery(GetAllBrandsFilters filters) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from brands b ");
        if (filters.getAddAliases()) {
            sb.append("left join brands_aliases a on a.brands_id = b.__id ");
        }
        sb.append("order by b.__id");

        if (filters.getLimit() != null) {
            sb.append(" limit " + filters.getLimit());
            if (filters.getPage() != null) {
                sb.append(" offset " + ((filters.getPage() - 1) * filters.getLimit()));
            }
        }
        JdbcTemplate tpl = new JdbcTemplate(dataSource);
        return tpl.query(sb.toString(), new BrandExtractor());
    }

    @Override
    public Integer countBrands() {

        TypedQuery<Long> jpaQuery = this.em.createNamedQuery(BrandDTO.COUNT_BRANDS, Long.class);

        return Integer.valueOf(jpaQuery.getSingleResult().intValue());
    }

    @Override
    public BrandBO getBrandById(Long brandId, Boolean addAliases, boolean useCache) {
        BrandBO result = null;
        String namedQuery = BrandDTO.FIND_BY_ID;

        //first get in the cache
        //create key
        IdCacheKey key = new IdCacheKey(brandId, addAliases);
        if (useCache) {
            result = super.getFromCacheById(key);
        }

        if (result == null) {

            TypedQuery<BrandDTO> jpaQuery = this.em.createNamedQuery(namedQuery, BrandDTO.class);
            jpaQuery.setParameter("brandId", brandId);

            List<BrandDTO> tmpRes = jpaQuery.getResultList();
            if (tmpRes != null && tmpRes.size() > 0) {
                if (addAliases) {
                    tmpRes.get(0).getBrandAliases();
                }

                result = this.adapter.adapt(tmpRes.get(0), addAliases);
                //put in cache
                super.putInCacheById(key, result);
            }
        }
        return result;
    }

    @Override
    public List<BrandBO> getBrandsByIds(List<Long> ids, boolean getAliases, boolean useCache) {
        List<BrandBO> result = new ArrayList<BrandBO>();
        if (ids != null && ids.size() > 0) {
            TypedQuery<BrandDTO> jpaQuery = this.em.createNamedQuery(getAliases ? BrandDTO.FIND_BY_IDS_INCLUDING_ALIASES
                    : BrandDTO.FIND_BY_IDS, BrandDTO.class);
            jpaQuery.setParameter("brandIds", ids);
            List<BrandDTO> tmpRes = jpaQuery.getResultList();
            for (BrandDTO item : tmpRes) {
                result.add(this.adapter.adapt(item, getAliases));
            }
            /*for (Long id : ids) {
                BrandBO bRes = getBrandById(id, getAliases, useCache);
                if (bRes != null) {
                    result.add(bRes);
                }
            }*/
        }
        /*
         *  TypedQuery<String> jpaQuery = this.em.createNamedQuery(queryName, String.class);
        jpaQuery.setParameter("names", names);
        return jpaQuery.getResultList();
         */
        return result;
    }

    @Override
    public List<BrandBO> getBrandsByName(GetBrandsByNameFilters filters, boolean useCache) {
        List<BrandBO> result = null;

        //first get in the cache
        //create key
        NameCacheKey key = new NameCacheKey(filters.getName(), filters.getType(), filters.getAddAliases(),
                filters.getIncludeSeoName());
        if (useCache) {
            result = super.getFromCacheByName(key);
        }

        if (result == null) {
            result = new ArrayList<BrandBO>(2);
            CriteriaBuilder qb = this.em.getCriteriaBuilder();
            CriteriaQuery<BrandDTO> c = qb.createQuery(BrandDTO.class).distinct(true);
            Root<BrandDTO> p = c.from(BrandDTO.class);
            Join<BrandDTO, BrandAliasDTO> r = null;

            if (filters.getAddAliases() != null && filters.getAddAliases()) {
                r = p.join(BrandDTO_.brandAliases, JoinType.LEFT);
            }

            c.where(this.getBrandsByNamePredicateList(qb, p, r, filters));

            TypedQuery<BrandDTO> jpaQuery = this.em.createQuery(c);

            List<BrandDTO> tmpRes = jpaQuery.getResultList();
            for (BrandDTO item : tmpRes) {
                result.add(this.adapter.adapt(item, filters.getAddAliases()));
            }
            //put in cache
            super.putInCacheByName(key, result);
        }

        return result;
    }

    protected Predicate getBrandsByNamePredicateList(CriteriaBuilder qb, Root<BrandDTO> p,
                                                     Join<BrandDTO, BrandAliasDTO> r, GetBrandsByNameFilters filters) {

        Predicate disjunction = qb.disjunction();
        List<Predicate> predicates = this.getNamePredicates(qb, p, r, filters.getName(), filters.getType(),
                filters.getIncludeSeoName());

        if (predicates.size() > 0) {
            disjunction = qb.or(predicates.get(0));
            predicates.remove(0);
        }

        for (Predicate predicate : predicates) {
            disjunction = qb.or(disjunction, predicate);
        }

        return disjunction;
    }

    @Override
    public List<BrandBO> getBrandsByNormalizedName(GetBrandsByNameFilters filters, boolean useCache) {
        List<BrandBO> result = null;

        //first get in the cache
        //create key
        NormalizedNameCacheKey key = new NormalizedNameCacheKey(filters.getName(), filters.getType(), filters.getAddAliases(),
                filters.getIncludeSeoName());
        if (useCache) {
            result = super.getFromCacheByName(key);
        }

        if (result == null) {
            result = new ArrayList<BrandBO>(2);
            CriteriaBuilder qb = this.em.getCriteriaBuilder();
            CriteriaQuery<BrandDTO> c = qb.createQuery(BrandDTO.class).distinct(true);
            Root<BrandDTO> p = c.from(BrandDTO.class);
            Join<BrandDTO, BrandAliasDTO> r = null;

            if (filters.getAddAliases() != null && filters.getAddAliases()) {
                r = p.join(BrandDTO_.brandAliases, JoinType.LEFT);
            }
            c.where(this.getBrandsByNormalizedNamePredicateList(qb, p, r, filters));
            TypedQuery<BrandDTO> jpaQuery = this.em.createQuery(c);
            List<BrandDTO> tmpRes = jpaQuery.getResultList();
            for (BrandDTO item : tmpRes) {
                result.add(this.adapter.adapt(item, filters.getAddAliases()));
            }
            //put in cache
            super.putInCacheByName(key, result);
        }
        return result;
    }

    protected Predicate getBrandsByNormalizedNamePredicateList(CriteriaBuilder qb, Root<BrandDTO> p,
                                                               Join<BrandDTO, BrandAliasDTO> r, GetBrandsByNameFilters filters) {
        Predicate disjunction = qb.disjunction();
        List<Predicate> predicates = this.getNameNormalizedPredicates(qb, p, r, filters.getName(), filters.getType());
        if (predicates.size() > 0) {
            disjunction = qb.or(predicates.get(0));
            predicates.remove(0);
        }
        for (Predicate predicate : predicates) {
            disjunction = qb.or(disjunction, predicate);
        }
        return disjunction;
    }

    /**
     * Type of comparison
     * <li> exact : exact search on brand name large : all brands beginning with the
     * searched name
     * <li> large_split : all brands beginning with one of the searched
     * name
     * <li> extra_large : all brands containing the searched name
     * <li> extra_large_split : all brands containing one of the searched name
     * <li> exact_alias : exact search on alias name
     * <li>large_alias : all aliases beginning with searched name
     * <li>large_alias_split : all aliases beginning with one of the searched name
     * <li> extra_large_alias : all aliases containing the searched
     * name
     * <li> extra_large_alias_split : all aliases containing one of the searched
     * names
     *
     * @param qb
     * @param p
     * @param r
     * @param name
     * @param type
     * @param includeSeoName
     * @return
     */
    protected List<Predicate> getNamePredicates(CriteriaBuilder qb, Root<BrandDTO> p, Join<BrandDTO, BrandAliasDTO> r,
                                                String name, SearchBrandsTypeEnum type, Boolean includeSeoName) {

        List<Predicate> conditions = new ArrayList<Predicate>();
        List<Predicate> seoConditions = new ArrayList<Predicate>();
        List<String> names;

        switch (type) {
            case LARGE:
                conditions.add(qb.like(p.get(BrandDTO_.name), name + "%"));
                seoConditions.add(qb.like(p.get(BrandDTO_.seoName), name + "%"));
                break;

            case LARGE_ALIAS:
                conditions.add(qb.like(r.get(BrandAliasDTO_.name), name + "%"));
                break;

            case LARGE_SPLIT:
                names = this.splitName(name);
                for (String item : names) {
                    conditions.add(qb.like(p.get(BrandDTO_.name), item + "%"));
                    seoConditions.add(qb.like(p.get(BrandDTO_.seoName), name + "%"));
                }
                break;

            case LARGE_ALIAS_SPLIT:
                names = this.splitName(name);
                for (String item : names) {
                    conditions.add(qb.like(r.get(BrandAliasDTO_.name), item + "%"));
                }
                break;

            case EXTRA_LARGE_SPLIT:
                names = this.splitName(name);
                for (String item : names) {
                    conditions.add(qb.like(p.get(BrandDTO_.name), "%" + item + "%"));
                    seoConditions.add(qb.like(p.get(BrandDTO_.seoName), "%" + item + "%"));
                }
                break;

            case EXTRA_LARGE_ALIAS_SPLIT:
                names = this.splitName(name);
                for (String item : names) {
                    conditions.add(qb.like(r.get(BrandAliasDTO_.name), "%" + item + "%"));
                }
                break;

            case EXTRA_LARGE:
                conditions.add(qb.like(p.get(BrandDTO_.name), "%" + name + "%"));
                seoConditions.add(qb.like(p.get(BrandDTO_.seoName), "%" + name + "%"));
                break;

            case EXTRA_LARGE_ALIAS:
                conditions.add(qb.like(r.get(BrandAliasDTO_.name), "%" + name + "%"));
                break;

            case EXACT_ALIAS:
                conditions.add(qb.equal(r.get(BrandAliasDTO_.name), name));
                break;

            case EXACT_BRAND_OR_ALIAS:
                conditions.add(qb.like(p.get(BrandDTO_.name), name));
                seoConditions.add(qb.like(p.get(BrandDTO_.seoName), name));
                conditions.add(qb.equal(r.get(BrandAliasDTO_.name), name));
                break;

            default:
                conditions.add(qb.equal(p.get(BrandDTO_.name), name));
                seoConditions.add(qb.equal(p.get(BrandDTO_.seoName), name));
                break;
        }

        if (includeSeoName != null && includeSeoName) {
            conditions.addAll(seoConditions);
        }

        return conditions;
    }

    /**
     * Name normalized predicate. does not support aliases or SEO condition
     * Type of comparison
     * <li> exact : exact search on brand name large : all brands beginning with the
     * searched name
     * <li> large_split : all brands beginning with one of the searched
     * name
     * <li> extra_large : all brands containing the searched name
     * <li> extra_large_split : all brands containing one of the searched name
     * <li> exact_alias : exact search on alias name
     * <li>large_alias : all aliases beginning with searched name
     * <li>large_alias_split : all aliases beginning with one of the searched name
     * <li> extra_large_alias : all aliases containing the searched
     * name
     * <li> extra_large_alias_split : all aliases containing one of the searched
     * names
     *
     * @param qb
     * @param p
     * @param name
     * @param type
     * @return
     */
    protected List<Predicate> getNameNormalizedPredicates(CriteriaBuilder qb, Root<BrandDTO> p,
                                                          Join<BrandDTO, BrandAliasDTO> r, String name, SearchBrandsTypeEnum type) {
        List<Predicate> conditions = new ArrayList<Predicate>();
        List<String> names;

        switch (type) {
            case LARGE:
                conditions.add(qb.like(p.get(BrandDTO_.normalizedName), name + "%"));
                break;

            case LARGE_SPLIT:
                names = this.splitName(name);
                for (String item : names) {
                    conditions.add(qb.like(p.get(BrandDTO_.normalizedName), item + "%"));
                }
                break;
            case EXTRA_LARGE_SPLIT:
                names = this.splitName(name);
                for (String item : names) {
                    conditions.add(qb.like(p.get(BrandDTO_.normalizedName), "%" + item + "%"));
                }
                break;

            case EXTRA_LARGE:
                conditions.add(qb.like(p.get(BrandDTO_.normalizedName), "%" + name + "%"));
                break;

            case EXACT_ALIAS:
                conditions.add(qb.equal(r.get(BrandAliasDTO_.nameNormalized), name));
                break;

            case LARGE_ALIAS:
                conditions.add(qb.like(r.get(BrandAliasDTO_.nameNormalized), name + "%"));
                break;

            case LARGE_ALIAS_SPLIT:
                names = this.splitName(name);
                for (String item : names) {
                    conditions.add(qb.like(r.get(BrandAliasDTO_.nameNormalized), item + "%"));
                }
                break;

            case EXTRA_LARGE_ALIAS:
                conditions.add(qb.like(r.get(BrandAliasDTO_.nameNormalized), "%" + name + "%"));
                break;

            case EXTRA_LARGE_ALIAS_SPLIT:
                names = this.splitName(name);
                for (String item : names) {
                    conditions.add(qb.like(r.get(BrandAliasDTO_.nameNormalized), "%" + item + "%"));
                }
                break;
            case EXACT_BRAND_OR_ALIAS:
                conditions.add(qb.equal(p.get(BrandDTO_.normalizedName), name));
                conditions.add(qb.equal(r.get(BrandAliasDTO_.nameNormalized), name));
                break;

            default:
                conditions.add(qb.equal(p.get(BrandDTO_.normalizedName), name));
                break;
        }
        return conditions;
    }

    /**
     * will NOT returns items where lenght is <= 2
     *
     * @param name
     * @return
     */
    protected List<String> splitName(String name) {

        String[] splitName = name.split(" ");
        List<String> result = new ArrayList<String>();

        for (String string : splitName) {
            if (string.length() > 2) {
                result.add(string);
            }
        }

        return result;
    }

    @Override
    public int save(List<BrandBO> brandBoList) {
        if (brandBoList == null || brandBoList.isEmpty()) {
            logger.warn("parameter brandBoList is empty");
            return 0;
        }

        Set<String> allAliasesList = new HashSet<String>();
        Set<String> allBrandsList = new HashSet<String>();
        Map<String, BrandDTO> toInsert = new HashMap<String, BrandDTO>();
        Set<BrandAliasDTO> standAloneAliases = new HashSet<BrandAliasDTO>();
        //invalid all caches
        super.clearCaches();

        //get lists of already inserted names and aliases in brandBoList
        for (BrandBO brandBO : brandBoList) {
            // Adding brandDto
            this.addToBrand(allBrandsList, brandBO);
            // Adding brand aliases
            this.addToAlias(allAliasesList, brandBO.getBrandAliases());
        }
        // Getting all aliases and brands already inserted
        List<String> alreadyInsertedAliases = (allAliasesList.isEmpty()) ? new ArrayList<String>() : this
                .getAlreadyInsertedNames(BrandAliasDTO.FIND_NAMES_INSERTED, allAliasesList);
        List<String> alreadyInsertedBrands = (allBrandsList.isEmpty()) ? new ArrayList<String>() : this
                .getAlreadyInsertedNames(BrandDTO.FIND_NAMES_INSERTED, allBrandsList);

        // cleaning the list to insert
        for (BrandBO brandBO : brandBoList) {
            //if name != null && name !in alreadyInsertedBrands
            if (brandBO.getName() != null && !alreadyInsertedBrands.contains(brandBO.getName())) {
                //if aliases != null && !in alreadyInsertedAliases
                if (brandBO.getBrandAliases() != null && !brandBO.getBrandAliases().isEmpty()) {
                    //clean alias list
                    Set<BrandAliasBO> aliasesToInsert = new HashSet<BrandAliasBO>();
                    for (BrandAliasBO alias : brandBO.getBrandAliases()) {
                        if (alias.getName() != null && !alreadyInsertedAliases.contains(alias.getName())) {
                            aliasesToInsert.add(alias);
                        }
                    }
                    //replace old alias list by the cleaned one
                    brandBO.setBrandAliases(aliasesToInsert);
                }
                //add to the list of inserts
                toInsert.put(brandBO.getName(), this.adapter.adapt(brandBO));
            }
        }


        // if brand already exists as an alias : get the id, remove from the list to insert
        // get all alias and add them : standalone .use cleaned list here to get aliases not already in DB
        List<BrandAliasDTO> insertedAliasWithBrandNameList = (allBrandsList.isEmpty()) ? new LinkedList<BrandAliasDTO>() : this
                .getAlreadyInsertedAliases(toInsert.keySet());
        if (insertedAliasWithBrandNameList != null && !insertedAliasWithBrandNameList.isEmpty()) {//TODO get the alias, not the name
            for (BrandAliasDTO alias : insertedAliasWithBrandNameList) {
                logger.warn("Invalid brand name " + alias.getName() + " . It already exists as an alias.");
                for (BrandAliasDTO a : toInsert.get(alias.getName()).getBrandAliases()) {
                    a.setBrand(alias.getBrand());//insert all aliases and link them to the brand already in DB
                    standAloneAliases.add(a);
                }
                toInsert.remove(alias.getName());
            }
        }
        int inserted = 0;
        // Inserting new brands
        for (BrandDTO dto : toInsert.values()) {
            this.getEm().persist(dto);
            inserted++;
        }
        // Inserting standalone aliases : case where the brand has aliases, but the brand itself is an already existing alias
        for (BrandAliasDTO dtoToSave : standAloneAliases) {
            this.getEm().persist(dtoToSave);
            inserted++;
        }
        return inserted;
    }

    public BrandBO setSeoName(String name, Long brandId) {
        //invalid all caches
        super.clearCaches();
        String namedQuery = BrandDTO.FIND_BY_ID;

        TypedQuery<BrandDTO> jpaQuery = this.em.createNamedQuery(namedQuery, BrandDTO.class);
        jpaQuery.setParameter("brandId", brandId);

        try {
            BrandDTO tmpRes = jpaQuery.getSingleResult();
            tmpRes.setSeoName(name);
            em.merge(tmpRes);
            em.flush();
            return adapter.adapt(tmpRes);
        } catch (NonUniqueResultException e) {
            throw new LoadDBException(e);
        } catch (NoResultException e) {
            throw new NotFoundException(e);
        }
    }

   

    private void addToAlias(Set<String> aliases, Set<BrandAliasBO> brandAliasDtoSet) {
        if (brandAliasDtoSet != null) {
            for (BrandAliasBO aliasDTO : brandAliasDtoSet) {
                if (aliasDTO.getName() != null) {
                    aliases.add(aliasDTO.getName());
                }
            }
        }
    }

    private void addToBrand(Set<String> brands, BrandBO brand) {
        if (brand.getName() != null) {
            brands.add(brand.getName());
        }
    }

    /**
     * Find all entity where entity.name is in the provided names list
     *
     * @param queryName the jpa query namr
     * @param names     a non null names list
     * @return
     */
    private List<String> getAlreadyInsertedNames(String queryName, Set<String> names) {
        if (names == null || names.isEmpty()) {
            return new ArrayList<String>();
        }
        TypedQuery<String> jpaQuery = this.em.createNamedQuery(queryName, String.class);
        jpaQuery.setParameter("names", names);
        return jpaQuery.getResultList();
    }

    /**
     * Find all entity where entity.name is in the provided names list
     *
     * @param queryName the jpa query namr
     * @param names     a non null names list
     * @return
     */
    private List<BrandAliasDTO> getAlreadyInsertedAliases(Set<String> names) {
        if (names == null || names.isEmpty()) {
            return new ArrayList<BrandAliasDTO>();
        }
        TypedQuery<BrandAliasDTO> jpaQuery = this.em.createNamedQuery(BrandAliasDTO.FIND_ALIASES_INSERTED, BrandAliasDTO.class);
        jpaQuery.setParameter("names", names);
        return jpaQuery.getResultList();
    }

    @Override
    public IBrandAdapter getAdapter() {
        return this.adapter;
    }

    public void setAdapter(IBrandAdapter adapter) {
        this.adapter = adapter;
    }

    public EntityManager getEm() {
        return this.em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ICacheService getCacheService() {
        return cacheService;
    }

    public void setCacheService(ICacheService cacheService) {
        this.cacheService = cacheService;
    }
}
