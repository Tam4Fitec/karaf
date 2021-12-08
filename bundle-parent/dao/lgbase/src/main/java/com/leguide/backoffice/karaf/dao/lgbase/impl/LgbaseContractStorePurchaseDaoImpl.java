package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseContractStorePurchaseDao;
import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseContractStorePurchase;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class LgbaseContractStorePurchaseDaoImpl implements LgbaseContractStorePurchaseDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * Finds shopsite current purchase
     *
     * @param storeUid storeUid
     * @return current purchase (array with consumption/nb clicks/avg cpc
     */
    @Override
    public Object[] findShopsiteCurrentPurchase(Long storeUid) {
        DateTime now = DateTime.now();
        Date begin = now.withDayOfMonth(1).withTimeAtStartOfDay().toDate();
        Date end = now.dayOfMonth().withMaximumValue().secondOfDay().withMaximumValue().toDate();
        Query query = em.createNamedQuery(LgbaseContractStorePurchase.FIND_SHOPSITE_CURRENT_PURCHASE);
        query.setParameter("storeUid", storeUid);
        query.setParameter("begin", begin);
        query.setParameter("end", end);

        List result = query.getResultList();
        if (result.size() > 0) {
            return (Object[]) result.get(0);
        } else {
            return null;
        }
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
