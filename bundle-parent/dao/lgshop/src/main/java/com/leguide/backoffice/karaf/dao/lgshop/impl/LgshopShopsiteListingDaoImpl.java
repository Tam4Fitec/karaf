package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteListingDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteListing;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LgshopShopsiteListingDaoImpl implements LgshopShopsiteListingDao {

    @PersistenceContext
	private EntityManager em;

	@Override
	public LgshopShopsiteListing findById(Long id) {
		return em.find(LgshopShopsiteListing.class, id);
	}

	@Override
	public void create(LgshopShopsiteListing lgshopShopsiteListing) {
		em.persist(lgshopShopsiteListing);
	}

	@Override
	public LgshopShopsiteListing update(LgshopShopsiteListing lgshopShopsiteListing) {
		return em.merge(lgshopShopsiteListing);
	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

}
