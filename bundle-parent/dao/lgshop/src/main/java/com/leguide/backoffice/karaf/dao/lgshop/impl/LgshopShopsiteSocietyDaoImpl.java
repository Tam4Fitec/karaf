package com.leguide.backoffice.karaf.dao.lgshop.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteSocietyDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteSociety;
import org.springframework.stereotype.Repository;

@Repository
public class LgshopShopsiteSocietyDaoImpl implements LgshopShopsiteSocietyDao {

    @PersistenceContext
	private EntityManager em;


	public LgshopShopsiteSocietyDaoImpl() {

	}

	/*
	 * (non-Javadoc)
	 * @see com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteSocietyDao#create(com.leguide.backoffice.karaf.models.lgshop.ShopsiteSociety)
	 */
	@Override
	public void create(LgshopShopsiteSociety lgshopShopsiteSociety) {
		em.persist(lgshopShopsiteSociety);

	}


	/* (non-Javadoc)
	 * @see com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteSocietyDao#findById(java.lang.Long)
	 */
	@Override
	public LgshopShopsiteSociety findById(Long id) {
		return em.find(LgshopShopsiteSociety.class, id);
	}

	@SuppressWarnings("unchecked")
    @Override
	public String findTypeSociety(Long idLabel){
		String request =
				"	select lbl_locale, lbl_label from rf_label lbl "
			+	"	where lbl_enabled= 'Y' and lbl_namespace = 'companytypes' and id_label = ?";
		Query query = em.createNativeQuery(request, "SocietyCountriesResult").setParameter(1, idLabel);

		List<LocaleLabelTuple> resultList = query.getResultList();
		if(resultList.size() > 1) {
			for (LocaleLabelTuple tuple : resultList) {
				if("en_GB".equals(tuple.getLocale()))
					return tuple.getLabel();
			}
			return null;
		} else if(resultList.size() == 1)
			return resultList.get(0).getLabel();
		else return null;
	}

	/*
	 * @see com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteSocietyDao#update(com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteSociety)
	 */
	@Override
	public LgshopShopsiteSociety update(LgshopShopsiteSociety lgshopShopsiteSociety) {
		return em.merge(lgshopShopsiteSociety);
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}



}
