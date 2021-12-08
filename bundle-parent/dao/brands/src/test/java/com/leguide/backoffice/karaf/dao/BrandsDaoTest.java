package com.leguide.backoffice.karaf.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hazelcast.core.HazelcastInstance;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllBrandsFilters;
import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.brands.common.utils.enums.SearchBrandsTypeEnum;
import com.leguide.backoffice.karaf.dao.GetBrandsByNameFiltersUtils;
import com.leguide.backoffice.karaf.dao.brands.IBrandsDAO;
import com.leguide.backoffice.karaf.dao.brands.adapters.impl.BrandAdapter;
import com.leguide.backoffice.karaf.dao.brands.adapters.impl.BrandAliasAdapter;
import com.leguide.backoffice.karaf.dao.brands.cache.CacheServiceImpl;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandAliasDTO;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandDTO;
import com.leguide.backoffice.karaf.dao.brands.impl.BrandsDAOImpl;
import com.leguide.backoffice.karaf.services.hazelcast.impl.HazelcastServiceImpl;

@ContextConfiguration("classpath:dao-test-context.xml")
public class BrandsDaoTest extends AbstractDaoTest {

//  Type of comparison
//
//  exact : exact search on brand name
//  large : all brands beginning with the searched name
//  large_split : all brands beginning with one of the searched name
//  extra_large : all brands containing the searched name
//  extra_large split : all brands containing one of the searched name
//  exact_alias : exact search on alias name
//  large_alias : all aliases beginning with searched name
//  large_alias_split : all aliases beginning with one of the searched name
//  extra_large_alias : all aliases containing the searched name
//  extra_large_alias_split : all aliases containing one of the searched names

    @Autowired
    IBrandsDAO brandsDao;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Autowired
    private CacheServiceImpl cacheService;

    @Before
    public void setUp() {
        HazelcastServiceImpl hazelcastService = new HazelcastServiceImpl();
        hazelcastService.setInstance(hazelcastInstance);
        cacheService.setHazelcastService(hazelcastService);
        brandsDao.setCacheService(cacheService);
    }

    @After
    public void tearDown() {
        cacheService.clearCaches();
    }

    @Test
    public void testGetBrandsByName() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("brand_1",
                SearchBrandsTypeEnum.EXACT, false, false);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(1, list.size());
        BrandBO item = list.get(0);
        assertEquals("brand_1", item.getName());
        assertNull(item.getBrandAliases());
    }

    @Test
    public void testGetBrandsByNameWithAliases() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("brand_1",
                SearchBrandsTypeEnum.EXACT, false, true);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(1, list.size());
        BrandBO item = list.get(0);
        assertEquals("brand_1", item.getName());
        assertNotNull(item.getBrandAliases());
    }

    @Test
    public void testGetBrandsByNameNoResult() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("test",
                SearchBrandsTypeEnum.EXACT, false, false);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(0, list.size());
    }

    @Test
    public void testGetBrandsByNameLarge() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("br",
                SearchBrandsTypeEnum.LARGE, false, false);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(3, list.size());
    }

    @Test
    public void testGetBrandsByNameExtraLarge() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("rand_",
                SearchBrandsTypeEnum.EXTRA_LARGE, false, false);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(3, list.size());
    }

    @Test
    public void testGetBrandsByNameExtraLargeSplit() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("test brand",
                SearchBrandsTypeEnum.EXTRA_LARGE_SPLIT, true, false);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(3, list.size());
    }

    @Test
    public void testGetBrandsByNameExactALias() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("alias_1",
                SearchBrandsTypeEnum.EXACT_ALIAS, true, true);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(1, list.size());
    }

    @Test
    public void testGetBrandsByNameLargeALias() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("ali",
                SearchBrandsTypeEnum.LARGE_ALIAS, true, true);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(1, list.size());
    }

    @Test
    public void testGetBrandsByNameLargeALiasSplit() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("test ali",
                SearchBrandsTypeEnum.LARGE_ALIAS_SPLIT, true, true);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(1, list.size());
    }

    @Test
    public void testGetBrandsByNameExtraLargeALias() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("lias",
                SearchBrandsTypeEnum.EXTRA_LARGE_ALIAS, true, true);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(1, list.size());
    }

    @Test
    public void testGetBrandsByNameExtraLargeALiasSplit() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("test alias",
                SearchBrandsTypeEnum.EXTRA_LARGE_ALIAS_SPLIT, true, true);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(1, list.size());
    }

    @Test
    public void testGetBrandsBySeoName() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("brand_1_seo",
                SearchBrandsTypeEnum.EXACT, true, false);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(1, list.size());
        BrandBO item = list.get(0);
        assertEquals("brand_1", item.getName());
    }

    @Test
    public void testGetBrandsBySeoNameExtraLargeSplit() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("test 1_seo",
                SearchBrandsTypeEnum.EXTRA_LARGE_SPLIT, true, true);
        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);

        assertEquals(1, list.size());
        BrandBO item = list.get(0);
        assertEquals("brand_1", item.getName());
        assertEquals(2, item.getBrandAliases().size());
    }

    @Test
    public void testGetBrandsByNameOrAliasName() {

        GetBrandsByNameFilters filtersBrands = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("brand_2",
                SearchBrandsTypeEnum.EXACT_BRAND_OR_ALIAS, false, true);
        List<BrandBO> listBrand = this.brandsDao.getBrandsByName(filtersBrands, false);

        assertEquals(1, listBrand.size());
        BrandBO brand2 = listBrand.get(0);
        assertEquals("brand_2", brand2.getName());

        GetBrandsByNameFilters filtersAlias = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("alias_1",
                SearchBrandsTypeEnum.EXACT_BRAND_OR_ALIAS, false, true);
        List<BrandBO> listAlias = this.brandsDao.getBrandsByName(filtersAlias, false);

        assertEquals(1, listAlias.size());
        BrandBO brand1 = listAlias.get(0);
        assertEquals("brand_1", brand1.getName());
        assertEquals(2, brand1.getBrandAliases().size());
    }

    @Test
    public void testGetBrandsByNameOrAliasNameFail() {

        GetBrandsByNameFilters filtersBrands = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("brand",
                SearchBrandsTypeEnum.EXACT_BRAND_OR_ALIAS, false, true);
        List<BrandBO> listBrand = this.brandsDao.getBrandsByName(filtersBrands, false);
        assertEquals(0, listBrand.size());

        GetBrandsByNameFilters filtersAlias = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("alias",
                SearchBrandsTypeEnum.EXACT_BRAND_OR_ALIAS, false, true);
        List<BrandBO> listAlias = this.brandsDao.getBrandsByName(filtersAlias, false);
        assertEquals(0, listAlias.size());
    }

    @Test
    public void testgetBrandById() {
        BrandBO brandBo = this.brandsDao.getBrandById(1L, false, false);

        assertEquals("brand_1", brandBo.getName());
        assertNull(brandBo.getBrandAliases());
    }

    @Test
    public void testgetBrandByIdWithAlias() {
        BrandBO brandBo = this.brandsDao.getBrandById(1L, true, false);

        assertEquals("brand_1", brandBo.getName());
        assertEquals(2, brandBo.getBrandAliases().size());
    }

    @Test
    public void testgetBrandByIdWithNoResult() {
        assertNull(this.brandsDao.getBrandById(0L, true, false));
    }

    @Test
    public void testSaveOneNameWithAliases() {
        List<BrandBO> toInsert = new ArrayList<BrandBO>();
        BrandBO bo1 = new BrandBO();
        bo1.setName("Ouza");
        bo1.setNormalizedName("ouza");
        Set<BrandAliasBO> toInsertAlias = new HashSet<BrandAliasBO>();
        BrandAliasBO alias1 = new BrandAliasBO();
        alias1.setName("Ouzaa");
        alias1.setNameNormalized("ouzaa");
        BrandAliasBO alias2 = new BrandAliasBO();
        alias2.setName("Ouzaaa");
        alias2.setNameNormalized("ouzaaa");
        toInsertAlias.add(alias1);
        toInsertAlias.add(alias2);

        bo1.setBrandAliases(toInsertAlias);
        toInsert.add(bo1);
        int inserted = this.brandsDao.save(toInsert);
        assertEquals(1, inserted);

        GetBrandsByNameFilters filter = new GetBrandsByNameFilters();
        filter.setName("Ouza");
        filter.setType(SearchBrandsTypeEnum.EXACT);
        filter.setAddAliases(true);
        List<BrandBO> result = this.brandsDao.getBrandsByName(filter, false);
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertEquals("Ouza", result.get(0).getName());
        assertEquals("ouza", result.get(0).getNormalizedName());
        assertEquals(2, result.get(0).getBrandAliases().size());

        //we don't know the order here, so we can't use an exact match
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0]).getName().startsWith("Ouzaa"));
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0]).getNameNormalized().startsWith("ouzaa"));
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[1]).getName().startsWith("Ouzaa"));
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[1]).getNameNormalized().startsWith("ouzaa"));

        assertEquals(result.get(0).getBrandsId(), ((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0])
                .getBrand().getBrandsId());
        assertEquals(result.get(0).getBrandsId(), ((BrandAliasBO) result.get(0).getBrandAliases().toArray()[1])
                .getBrand().getBrandsId());
    }

    @Test
    public void testSaveOneNameWithAliasesAlreadyInserted() {
        List<BrandBO> toInsert = new ArrayList<BrandBO>();
        BrandBO bo1 = new BrandBO();
        bo1.setName("Ouza");
        bo1.setNormalizedName("ouza");
        Set<BrandAliasBO> toInsertAlias = new HashSet<BrandAliasBO>();
        BrandAliasBO alias1 = new BrandAliasBO();
        alias1.setName("alias_1");
        alias1.setNameNormalized("normalized_alias_1");
        BrandAliasBO alias2 = new BrandAliasBO();
        alias2.setName("Ouzaaa");
        alias2.setNameNormalized("ouzaaa");
        toInsertAlias.add(alias1);
        toInsertAlias.add(alias2);

        bo1.setBrandAliases(toInsertAlias);
        toInsert.add(bo1);
        int inserted = this.brandsDao.save(toInsert);
        assertEquals(1, inserted);

        GetBrandsByNameFilters filter = new GetBrandsByNameFilters();
        filter.setName("Ouza");
        filter.setType(SearchBrandsTypeEnum.EXACT);
        filter.setAddAliases(true);
        List<BrandBO> result = this.brandsDao.getBrandsByName(filter, false);
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertEquals("Ouza", result.get(0).getName());
        assertEquals("ouza", result.get(0).getNormalizedName());
        assertEquals(1, result.get(0).getBrandAliases().size());

        //we don't know the order here, so we can't use an exact match
        assertEquals("Ouzaaa", ((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0]).getName());
        assertEquals("ouzaaa", ((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0]).getNameNormalized());

        assertEquals(result.get(0).getBrandsId(), ((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0])
                .getBrand().getBrandsId());
    }

    @Test
    public void testSaveTwoNamesAlreadyInserted() {
        List<BrandBO> toInsert = new ArrayList<BrandBO>();
        BrandBO bo1 = new BrandBO();
        bo1.setName("Ouza");
        bo1.setNormalizedName("ouza");
        Set<BrandAliasBO> toInsertAlias = new HashSet<BrandAliasBO>();
        BrandAliasBO alias1 = new BrandAliasBO();
        alias1.setName("Ouzaa");
        alias1.setNameNormalized("ouzaa");
        BrandAliasBO alias2 = new BrandAliasBO();
        alias2.setName("Ouzaaa");
        alias2.setNameNormalized("ouzaaa");
        toInsertAlias.add(alias1);
        toInsertAlias.add(alias2);

        bo1.setBrandAliases(toInsertAlias);
        toInsert.add(bo1);
        BrandBO alreadyInserted = new BrandBO();
        alreadyInserted.setName("brand_1");
        alreadyInserted.setNormalizedName("brand_1");
        toInsert.add(alreadyInserted);

        int inserted = this.brandsDao.save(toInsert);
        assertEquals(1, inserted);

        GetBrandsByNameFilters filter = new GetBrandsByNameFilters();
        filter.setName("Ouza");
        filter.setType(SearchBrandsTypeEnum.EXACT);
        filter.setAddAliases(true);
        List<BrandBO> result = this.brandsDao.getBrandsByName(filter, false);
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertEquals("Ouza", result.get(0).getName());
        assertEquals("ouza", result.get(0).getNormalizedName());
        assertEquals(2, result.get(0).getBrandAliases().size());

        //we don't know the order here, so we can't use an exact match
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0]).getName().startsWith("Ouzaa"));
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0]).getNameNormalized().startsWith("ouzaa"));
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[1]).getName().startsWith("Ouzaa"));
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[1]).getNameNormalized().startsWith("ouzaa"));

        assertEquals(result.get(0).getBrandsId(), ((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0])
                .getBrand().getBrandsId());
        assertEquals(result.get(0).getBrandsId(), ((BrandAliasBO) result.get(0).getBrandAliases().toArray()[1])
                .getBrand().getBrandsId());
    }

    @Test
    public void testSaveTwoNamesOneIsAlias() {
        List<BrandBO> toInsert = new ArrayList<BrandBO>();
        BrandBO bo1 = new BrandBO();
        bo1.setName("Ouza");
        bo1.setNormalizedName("ouza");
        Set<BrandAliasBO> toInsertAlias = new HashSet<BrandAliasBO>();
        BrandAliasBO alias1 = new BrandAliasBO();
        alias1.setName("Ouzaa");
        alias1.setNameNormalized("ouzaa");
        BrandAliasBO alias2 = new BrandAliasBO();
        alias2.setName("Ouzaaa");
        alias2.setNameNormalized("ouzaaa");
        toInsertAlias.add(alias1);
        toInsertAlias.add(alias2);
        bo1.setBrandAliases(toInsertAlias);
        toInsert.add(bo1);

        BrandBO alreadyAlias = new BrandBO();
        alreadyAlias.setName("alias_1");
        alreadyAlias.setNormalizedName("normalized_alias_1");
        Set<BrandAliasBO> toInsertAlias2 = new HashSet<BrandAliasBO>();
        BrandAliasBO alias1ToInsert = new BrandAliasBO();
        alias1ToInsert.setName("AliasToInsert");
        alias1ToInsert.setNameNormalized("aliastoinsertnormalized");
        BrandAliasBO alias1NotToInsert = new BrandAliasBO();
        alias1NotToInsert.setName("alias_1.1");
        alias1NotToInsert.setNameNormalized("normalized_alias_1.1");
        toInsertAlias2.add(alias1ToInsert);
        toInsertAlias2.add(alias1NotToInsert);
        alreadyAlias.setBrandAliases(toInsertAlias2);
        toInsert.add(alreadyAlias);

        int inserted = this.brandsDao.save(toInsert);
        assertEquals(2, inserted);

        GetBrandsByNameFilters filter = new GetBrandsByNameFilters();
        filter.setName("Ouza");
        filter.setType(SearchBrandsTypeEnum.EXACT);
        filter.setAddAliases(true);
        List<BrandBO> result = this.brandsDao.getBrandsByName(filter, false);
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertEquals("Ouza", result.get(0).getName());
        assertEquals("ouza", result.get(0).getNormalizedName());
        assertEquals(2, result.get(0).getBrandAliases().size());

        //we don't know the order here, so we can't use an exact match
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0]).getName().startsWith("Ouzaa"));
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0]).getNameNormalized().startsWith("ouzaa"));
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[1]).getName().startsWith("Ouzaa"));
        assertTrue(((BrandAliasBO) result.get(0).getBrandAliases().toArray()[1]).getNameNormalized().startsWith("ouzaa"));

        assertEquals(result.get(0).getBrandsId(), ((BrandAliasBO) result.get(0).getBrandAliases().toArray()[0])
                .getBrand().getBrandsId());
        assertEquals(result.get(0).getBrandsId(), ((BrandAliasBO) result.get(0).getBrandAliases().toArray()[1])
                .getBrand().getBrandsId());

        //check alias_1 not inserted
        filter = new GetBrandsByNameFilters();
        filter.setName("alias_1");
        filter.setType(SearchBrandsTypeEnum.EXACT);
        result = this.brandsDao.getBrandsByName(filter, false);
        assertNotNull(result);
        assertTrue(result.size() == 0);

        //check AliasToInsert inserted to brand 1
        filter = new GetBrandsByNameFilters();
        filter.setName("brand_1");
        filter.setAddAliases(true);
        filter.setType(SearchBrandsTypeEnum.EXACT);
        result = this.brandsDao.getBrandsByName(filter, false);
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertEquals(3, result.get(0).getBrandAliases().size());
    }

    @Test
    public void testSaveTwiceSameName() {
        List<BrandBO> toInsert = new ArrayList<BrandBO>();
        BrandBO bo1 = new BrandBO();
        bo1.setName("Ouza");
        bo1.setNormalizedName("ouza");
        BrandBO bo2 = new BrandBO();
        bo2.setName("Ouza");
        bo2.setNormalizedName("ouzaaa");

        toInsert.add(bo1);
        toInsert.add(bo2);

        int inserted = this.brandsDao.save(toInsert);
        assertEquals(1, inserted);

        GetBrandsByNameFilters filter = new GetBrandsByNameFilters();
        filter.setName("Ouza");
        filter.setType(SearchBrandsTypeEnum.EXACT);
        filter.setAddAliases(true);
        List<BrandBO> result = this.brandsDao.getBrandsByName(filter, false);
        assertNotNull(result);
        assertTrue(result.size() == 1);
    }


    @Test
    public void testGetBrandsByIdsListNull(){
        List<BrandBO> res = brandsDao.getBrandsByIds(null, false, true);
        assertNotNull(res);
        assertTrue(res.size() == 0);
        res = brandsDao.getBrandsByIds(new ArrayList<Long>(), false, true);
        assertNotNull(res);
        assertTrue(res.size() == 0);
    }

    @Test
    public void testGetBrandsByIds(){
        List<Long> ids = new ArrayList<Long>(5);
        ids.add(1l);
        ids.add(2l);
        ids.add(3l);
        ids.add(4l);
        ids.add(5l);
        List<BrandBO> res = brandsDao.getBrandsByIds(ids, false, true);
        assertNotNull(res);
        assertTrue(res.size() == 3);
        BrandBO bo1 = res.get(0);
        assertEquals(new Long(1), bo1.getBrandsId());
        assertNull(bo1.getBrandAliases());

        res = brandsDao.getBrandsByIds(ids, true, true);
        assertNotNull(res);
        assertTrue(res.size() == 3);
        bo1 = res.get(0);
        assertEquals(new Long(1), bo1.getBrandsId());
        assertNotNull(bo1.getBrandAliases());
        assertEquals(2, bo1.getBrandAliases().size());
    }

    protected BrandsDAOImpl mockBrandDAO() {

        BrandsDAOImpl dao = new BrandsDAOImpl();
        BrandAdapter brandAdapter = new BrandAdapter();
        EntityManager em = mock(EntityManager.class);
        dao.setEm(em);
        dao.setAdapter(brandAdapter);
        dao.setCacheService(cacheService);
        return dao;
    }
}
