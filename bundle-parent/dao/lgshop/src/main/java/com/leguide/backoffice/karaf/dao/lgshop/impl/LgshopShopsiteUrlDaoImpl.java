package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteUrlDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteUrl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LgshopShopsiteUrlDaoImpl implements LgshopShopsiteUrlDao {

    @PersistenceContext
    private EntityManager em;


    public LgshopShopsiteUrlDaoImpl() {

    }

    @Override
    public LgshopShopsiteUrl findById(Long idShopsite) {
        return em.find(LgshopShopsiteUrl.class, idShopsite);
    }

    @Override
    public void create(LgshopShopsiteUrl newShopsiteUrl) {
        em.persist(newShopsiteUrl);

    }


    @Override
    public LgshopShopsiteUrl update(LgshopShopsiteUrl newShopsiteUrl) {
        return em.merge(newShopsiteUrl);
    }


    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
