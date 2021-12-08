package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteReportSubscription;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteReportSubscriptionKey;

import java.util.Date;
import java.util.List;

public interface LgshopShopsiteReportSubscriptionDao {

    LgshopShopsiteReportSubscription findByShopsiteIdAndEmail(LgshopShopsiteReportSubscriptionKey key);

    List<LgshopShopsiteReportSubscription> findShopsiteSubscriptionsDayBetween(int beginMinuteOfDay, int endMinuteOfDay);

    List<LgshopShopsiteReportSubscription> findShopsiteSubscriptionsWeekBetween(int day, int beginMinuteOfDay, int endMinuteOfDay);

    boolean deleteSubscriptionReportForShopsite(Long shopsiteId);

    boolean deleteSubscriptionReportForShopsiteAndType(Long shopsiteId, String reportType);

    List<LgshopShopsiteReportSubscription> findObsoletePricingSubscription(Date beforeDate);

    void create(LgshopShopsiteReportSubscription shopsiteReportSubscription);

    void update(LgshopShopsiteReportSubscription shopsiteReportSubscription);

    void delete(LgshopShopsiteReportSubscription shopsiteReportSubscription);

	boolean deleteSubscriptionAlertForShopsite(Long shopsiteId);
}
