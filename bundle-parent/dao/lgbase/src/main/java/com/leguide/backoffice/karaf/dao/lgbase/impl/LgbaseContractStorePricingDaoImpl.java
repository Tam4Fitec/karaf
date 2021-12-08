package com.leguide.backoffice.karaf.dao.lgbase.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseContractStorePricingDao;
import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseContractStoreConsumption;
import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseContractStorePricing;

@Repository
public class LgbaseContractStorePricingDaoImpl implements LgbaseContractStorePricingDao {

    @PersistenceContext
    private EntityManager em;

    @Override
	public List<LgbaseContractStorePricing> getLastPricingContracts(String clientId, Date from) {
        TypedQuery<LgbaseContractStorePricing> query = em.createNamedQuery(LgbaseContractStorePricing.GET_LAST_PRICING_CONTRACTS_FROM_DATE, LgbaseContractStorePricing.class);
        query.setParameter("clientId", clientId);
        query.setParameter("startDate", from);
        return query.getResultList();
	}

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
