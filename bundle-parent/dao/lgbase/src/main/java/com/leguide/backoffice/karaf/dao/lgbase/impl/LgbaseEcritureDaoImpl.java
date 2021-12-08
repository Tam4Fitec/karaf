package com.leguide.backoffice.karaf.dao.lgbase.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseEcriturePrimaryKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseEcritureDao;
import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseEcriture;

@Repository
public class LgbaseEcritureDaoImpl implements LgbaseEcritureDao {

	private static final Logger logger = LoggerFactory.getLogger(LgbaseEcritureDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

	/*
	 * (non-Javadoc)
	 * @see com.leguide.backoffice.karaf.dao.lgbase.LgbaseEcritureDao#getBalance(java.lang.String)
	 */
	@Override
	public Double getBalance(String clientId) {

		Query query = em.createNativeQuery("select sum(debit)-sum(credit) from lgbase.lg_ecritures where auxiliaire= ? and ref_interne != 'ANO'");
    	query.setParameter(1, clientId);
    	try {
    		Double value = (Double) query.getSingleResult();
    		if(value == null)
    			return 0.0;
			return
				value;
    	} catch (NoResultException e) {
    		return new Double(0.0);
    	}
	}


    /*
     * (non-Javadoc)
     * @see com.leguide.backoffice.karaf.dao.lgbase.LgbaseEcritureDao#getEcritureForClient(java.lang.String)
     */
	@SuppressWarnings("unchecked")
    @Override
	public List<LgbaseEcriture> getEcritureForClient(String clientId) {
		 logger.debug("getEcritureForClient");

//		 TODO : Jpa gère mal les entités sans primarykey donc en attendant je contourne en passant en NativeQuery
//		 TypedQuery<LgbaseEcriture> query = em.createNamedQuery(LgbaseEcriture.FIND_ECRITURES_FOR_CLIENT, LgbaseEcriture.class);
//	     query.setParameter("clientId", clientId);
//	     logger.info("before getResultList");
//	     return query.getResultList();


		List<LgbaseEcriture> listEcritures= new ArrayList<LgbaseEcriture>();
		Query query = em.createNativeQuery("select debit as Debit,credit as Credit,ref_interne as Refinterne,lettrage as lettrage,date_echeance as DateEcheance from lgbase.lg_ecritures where auxiliaire= ? and ref_interne != 'ANO' order by date_echeance desc");
    	query.setParameter(1, clientId);
    	List<Object[]> resultList = query.getResultList();
    	logger.debug("after getResultList "+resultList.size());
    	for (Object[] objects : resultList) {
    		LgbaseEcriture lgbaseEcriture = new LgbaseEcriture();
            LgbaseEcriturePrimaryKey key = new LgbaseEcriturePrimaryKey();
            key.setRefInterne((String) objects[2]);
            lgbaseEcriture.setKey(key);
    		lgbaseEcriture.setDebit((Float) objects[0]);
    		lgbaseEcriture.setCredit((Float) objects[1]);
    		lgbaseEcriture.setLettrage((String) objects[3]);
    		lgbaseEcriture.setDateEcheance((Date) objects[4]);
    		listEcritures.add(lgbaseEcriture);
		}
	    return listEcritures;
	}
}
