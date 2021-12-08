package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteInternalNotificationDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteInternalNotification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LgshopShopsiteInternalNotificationDaoImpl implements LgshopShopsiteInternalNotificationDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public LgshopShopsiteInternalNotification findById(Long id) {
        return em.find(LgshopShopsiteInternalNotification.class, id);
    }

    @Override
    public void update(LgshopShopsiteInternalNotification lgshopShopsiteInternalNotification) {
        em.merge(lgshopShopsiteInternalNotification);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

	@Override
	public void create(LgshopShopsiteInternalNotification lgshopShopsiteInternalNotification) {
		em.persist(lgshopShopsiteInternalNotification);
	}
}
