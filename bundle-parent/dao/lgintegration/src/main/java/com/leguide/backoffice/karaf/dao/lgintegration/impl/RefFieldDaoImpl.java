package com.leguide.backoffice.karaf.dao.lgintegration.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.leguide.backoffice.karaf.dao.lgintegration.RefFieldDao;
import com.leguide.backoffice.karaf.models.lgintegration.catalog.RefFieldDTO;
import org.springframework.stereotype.Repository;

@Repository
public class RefFieldDaoImpl implements RefFieldDao {

    @PersistenceContext
	private EntityManager em;

	@Override
	public String findFieldLabelById(Long fieldId){
		String result = null;
		RefFieldDTO  fieldDTO = em.find(RefFieldDTO.class, fieldId);
		if(fieldDTO != null) {
			result = fieldDTO.getLabel();
		}
		return result;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}




}
