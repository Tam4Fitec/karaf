package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteSandboxDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteSandbox;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class LgshopShopsiteSandboxDaoImpl implements LgshopShopsiteSandboxDao {

    @PersistenceContext
    private EntityManager em;


    public LgshopShopsiteSandboxDaoImpl() {

    }

    protected LgshopShopsiteSandbox findById(Long id) {
        return em.find(LgshopShopsiteSandbox.class, id);
    }

    @Override
    public void create(LgshopShopsiteSandbox newShopsiteSandbox) {
        em.persist(newShopsiteSandbox);
    }


    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Long findDeliveryZoneByIdCountry(Integer countryId) {
        TypedQuery<Number> query = em.createNamedQuery(LgshopShopsiteSandbox.FIND_FLAG_DELIVERY_ZONE, Number.class);
        query.setParameter(1, countryId);
        try {
            return query.getSingleResult().longValue();
        } catch (NoResultException e) {
            return 1L;
        }
    }


}
