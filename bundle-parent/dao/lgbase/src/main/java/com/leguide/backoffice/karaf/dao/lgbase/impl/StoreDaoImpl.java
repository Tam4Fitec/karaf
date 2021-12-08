package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.StoreDao;
import com.leguide.backoffice.karaf.models.lgbase.merchant.Store;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * StoreDao implementation
 */
@Repository
public class StoreDaoImpl implements StoreDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * @param idShopsite idShopsite
     * @return storeId
     */
    public Store findStoreWithIdShopsite(Long idShopsite) {
        return em.find(Store.class, idShopsite);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
