package com.leguide.backoffice.karaf.dao.lgshop.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteStateDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteState;
import org.springframework.stereotype.Repository;

@Repository
public class LgshopShopsiteStateDaoImpl implements LgshopShopsiteStateDao {

    @PersistenceContext
	private EntityManager em;


	public LgshopShopsiteStateDaoImpl() {

	}

	@Override
	public LgshopShopsiteState findById(Long idShopsite) {
		return em.find(LgshopShopsiteState.class, idShopsite);
	}

    /*
     * (non-Javadoc)
     * @see com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteStateDao#create(com.leguide.backoffice.karaf.models.lgshop.ShopsiteState)
     */
	@Override
	public void create(LgshopShopsiteState newShopsiteState) {
		em.persist(newShopsiteState);
	}

	@Override
	public void update(LgshopShopsiteState lgshopShopsiteState) {
		em.merge(lgshopShopsiteState);
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}



}
