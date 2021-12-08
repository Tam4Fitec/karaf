package com.leguide.backoffice.karaf.dao.lgintegration.impl;

import com.leguide.backoffice.karaf.dao.lgintegration.CatalogDao;
import com.leguide.backoffice.karaf.models.lgintegration.catalog.CatalogDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CatalogDaoImpl implements CatalogDao {

    @PersistenceContext
    private EntityManager em;

    public static String REQ_CAT_BY_SHOPSITEID = "SELECT * FROM lgintegration.tb_catalog where id_shopsite = ?";

    public static String REQ_CAT_ACTIV_BY_SHOPSITEID = "SELECT tbc.id_catalog, tbc.id_shopsite, tbc.ctg_state,count(*) "
            + "  FROM lgintegration.tb_catalog tbc "
            + " inner join lgintegration.tb_source tbs on (tbs.id_catalog = tbc.id_catalog and src_active = 'Y') "
            + " where id_shopsite = ? "
            + " and tbc.ctg_active = 'Y' "
            + " and tbc.ctg_state in (3,0) "
            + " group by tbc.id_catalog ";


    @Override
    public CatalogDTO findByShopsiteId(Long shopsiteId) {

        Query query = em.createNativeQuery(REQ_CAT_BY_SHOPSITEID, CatalogDTO.class);
        query.setParameter(1, shopsiteId);
        try {
            return (CatalogDTO) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void create(CatalogDTO catalogDTO) {
        em.persist(catalogDTO);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


    @Override
    public Boolean isActiveCatalog(Long idShopsite) {
        Query query = em.createNativeQuery(REQ_CAT_ACTIV_BY_SHOPSITEID);
        query.setParameter(1, idShopsite);
        try {
            query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

}
