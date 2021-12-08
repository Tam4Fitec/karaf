package com.leguide.backoffice.karaf.dao.lgshop.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteCatalogDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LgshopShopsiteCatalogDaoImpl implements LgshopShopsiteCatalogDao{

    @PersistenceContext
	private EntityManager em;


	public LgshopShopsiteCatalogDaoImpl() {

	}

    /*
     * (non-Javadoc)
     * @see com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteCatalogDao#create(com.leguide.backoffice.karaf.models.lgshop.ShopsiteCatalog)
     */
	@Override
	public void create(LgshopShopsiteCatalog newShopsiteCatalog) {
		em.persist(newShopsiteCatalog);

	}

    protected LgshopShopsiteCatalog findById(Long id) {
        return em.find(LgshopShopsiteCatalog.class, id);
    }

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}


}
