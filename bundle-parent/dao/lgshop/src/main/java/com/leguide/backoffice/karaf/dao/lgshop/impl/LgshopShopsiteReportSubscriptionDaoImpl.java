package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteReportSubscriptionDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteReportSubscription;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteReportSubscriptionKey;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class LgshopShopsiteReportSubscriptionDaoImpl implements LgshopShopsiteReportSubscriptionDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public LgshopShopsiteReportSubscription findByShopsiteIdAndEmail(LgshopShopsiteReportSubscriptionKey key) {
        return em.find(LgshopShopsiteReportSubscription.class, key);
    }

    @Override
    public List<LgshopShopsiteReportSubscription> findShopsiteSubscriptionsDayBetween(int beginMinuteOfDay, int endMinuteOfDay) {
        TypedQuery<LgshopShopsiteReportSubscription> query = em.createNamedQuery(
                LgshopShopsiteReportSubscription.FIND_SHOPSITE_SUBSCRIPTIONS_DAY_BETWEEN, LgshopShopsiteReportSubscription.class);
        query.setParameter("begin", beginMinuteOfDay);
        query.setParameter("end", endMinuteOfDay);
        return query.getResultList();
    }

    @Override
    public List<LgshopShopsiteReportSubscription> findShopsiteSubscriptionsWeekBetween(int day, int beginMinuteOfDay, int endMinuteOfDay) {
        TypedQuery<LgshopShopsiteReportSubscription> query = em.createNamedQuery(
                LgshopShopsiteReportSubscription.FIND_SHOPSITE_SUBSCRIPTIONS_WEEK_BETWEEN, LgshopShopsiteReportSubscription.class);
        query.setParameter("day", String.valueOf(day));
        query.setParameter("begin", beginMinuteOfDay);
        query.setParameter("end", endMinuteOfDay);
        return query.getResultList();
    }

    @Override
    public void create(LgshopShopsiteReportSubscription shopsiteReportSubscription) {
        em.persist(shopsiteReportSubscription);
    }

    @Override
    public void update(LgshopShopsiteReportSubscription shopsiteReportSubscription) {
        em.merge(shopsiteReportSubscription);
    }

    @Override
    public void delete(LgshopShopsiteReportSubscription shopsiteReportSubscription) {
        em.remove(em.contains(shopsiteReportSubscription) ? shopsiteReportSubscription : em.merge(shopsiteReportSubscription));
    }

    @Override
    public boolean deleteSubscriptionReportForShopsite(Long shopsiteId) {
        Query query = em.createNativeQuery("delete from tb_shopsite_report_subscription where id_shopsite = ?");
        query.setParameter(1, shopsiteId);
        return query.executeUpdate() > 0;
    }
    
    @Override
    public boolean deleteSubscriptionAlertForShopsite(Long shopsiteId) {
        Query query = em.createNativeQuery("delete from tb_shopsite_alert_subscription where id_shopsite = ?");
        query.setParameter(1, shopsiteId);
        return query.executeUpdate() > 0;
    }


    @Override
    public boolean deleteSubscriptionReportForShopsiteAndType(Long shopsiteId, String reportType) {
        Query query = em.createNativeQuery("delete from tb_shopsite_report_subscription where id_shopsite = ? and report_type = ?");
        query.setParameter(1, shopsiteId);
        query.setParameter(2, reportType);
        return query.executeUpdate() > 0;
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<LgshopShopsiteReportSubscription> findObsoletePricingSubscription(Date beforeDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * ")
                .append("from tb_shopsite_report_subscription tbsrs ")
                .append("inner join lgbase.pricing_subscription ps on tbsrs.id_shopsite = ps.ps_shopsite_id ")
                .append("where report_type like 'PRICING%' ")
                .append("AND ps_end_date IS NOT NULL and ps_end_date < ? ");

        Query query = em.createNativeQuery(sb.toString(), LgshopShopsiteReportSubscription.class);
        query.setParameter(1, beforeDate);
        return query.getResultList();
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
