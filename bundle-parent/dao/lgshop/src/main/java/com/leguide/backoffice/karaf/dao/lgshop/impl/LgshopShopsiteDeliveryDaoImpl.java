package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteDeliveryDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteDelivery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LgshopShopsiteDeliveryDaoImpl implements LgshopShopsiteDeliveryDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public LgshopShopsiteDelivery findById(Long id) {
        return em.find(LgshopShopsiteDelivery.class, id);
    }

    @Override
    public void update(LgshopShopsiteDelivery lgshopShopsiteDelivery) {
        em.merge(lgshopShopsiteDelivery);
    }

    @Override
	public void create(LgshopShopsiteDelivery lgshopShopsiteDelivery) {
    	 em.persist(lgshopShopsiteDelivery);
	}

	public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
