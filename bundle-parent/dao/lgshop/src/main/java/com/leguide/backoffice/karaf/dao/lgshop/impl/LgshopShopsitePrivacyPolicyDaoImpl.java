package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsitePrivacyPolicyDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsitePrivacyPolicy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LgshopShopsitePrivacyPolicyDaoImpl implements LgshopShopsitePrivacyPolicyDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public LgshopShopsitePrivacyPolicy findById(Long id) {
        return em.find(LgshopShopsitePrivacyPolicy.class, id);
    }

    @Override
    public void update(LgshopShopsitePrivacyPolicy lgshopShopsitePrivacyPolicy) {
        em.merge(lgshopShopsitePrivacyPolicy);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

	@Override
	public void create(LgshopShopsitePrivacyPolicy lgshopShopsitePrivacyPolicy) {
		em.persist(lgshopShopsitePrivacyPolicy);
	}
}
