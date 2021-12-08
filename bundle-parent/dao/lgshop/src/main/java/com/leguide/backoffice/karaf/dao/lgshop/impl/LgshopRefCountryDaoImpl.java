package com.leguide.backoffice.karaf.dao.lgshop.impl;

import javax.persistence.*;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopRefCountryDao;
import com.leguide.backoffice.karaf.models.lgshop.referentiel.LgshopRefCountry;
import org.springframework.stereotype.Repository;

@Repository
public class LgshopRefCountryDaoImpl implements LgshopRefCountryDao {

    @PersistenceContext
	private EntityManager em;

	public LgshopRefCountryDaoImpl() {

	}

	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}


	@Override
	public Integer findInternalCountryByAlpha2Code(String alpha2Code) {
        TypedQuery<Number> query = em.createNamedQuery(LgshopRefCountry.FIND_INTERNAL_ID_COUNTRY_BY_ALPHA2CODE, Number.class);
		query.setParameter(1, alpha2Code);
        return query.getResultList().stream().findFirst().map(Number::intValue).orElse(null);
	}

	@Override
	public String findAlpha2CodeByInternalId(Integer id) {
		TypedQuery<String> query = em.createNamedQuery(LgshopRefCountry.FIND_ALPHA2CODE_COUNTRY_BY_INTERNAL_ID, String.class);
		query.setParameter(1, id);
		return query.getResultList().stream().findFirst().orElse(null);
	}

}
