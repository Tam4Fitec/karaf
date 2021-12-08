package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseContractStoreConsumptionDao;
import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseContractStoreConsumption;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class LgbaseContractStoreConsumptionDaoImpl implements LgbaseContractStoreConsumptionDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<LgbaseContractStoreConsumption> findByStoreFromDate(Long storeUid, Date now) {
        TypedQuery<LgbaseContractStoreConsumption> query = em.createNamedQuery(LgbaseContractStoreConsumption.FIND_BY_STORE_FROM_DATE, LgbaseContractStoreConsumption.class);
        query.setParameter("storeUid", storeUid);
        query.setParameter("startDate", new DateTime(now).minusMonths(11).withDayOfMonth(1).withTimeAtStartOfDay().toDate());
        return query.getResultList();
    }

    @Override
    public Optional<LgbaseContractStoreConsumption> findByStoreAtDate(Long storeUid, Date now) {
        TypedQuery<LgbaseContractStoreConsumption> query = em.createNamedQuery(LgbaseContractStoreConsumption.FIND_BY_STORE_AT_DATE, LgbaseContractStoreConsumption.class);
        query.setParameter("storeUid", storeUid);
        query.setParameter("startDate", new DateTime(now).withDayOfMonth(1).withTimeAtStartOfDay().toDate());
        return query.getResultList().stream().findFirst();
    }

    @Override
    public void update(LgbaseContractStoreConsumption csc) {
        findByStoreAtDate(csc.getStoreUid(), csc.getStartDate()).ifPresent(fullCsc -> {
            fullCsc.setMaximumAmount(csc.getMaximumAmount());
            fullCsc.setAmountAlert(csc.getAmountAlert());
            em.merge(fullCsc);
        });
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
