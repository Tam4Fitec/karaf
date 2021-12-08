package com.leguide.backoffice.karaf.bundle.dao.facade;

import java.util.List;

import com.leguide.backoffice.karaf.business.models.pojo.subscription.ShopsiteReportSubscription;

public interface ShopsiteSubscriptionReportDao {

    ShopsiteReportSubscription findShopsiteReportSubscription(Long shopsiteId, String contactEmail, ShopsiteReportSubscription.ReportType reportType);

    ShopsiteReportSubscription findShopsiteReportSubscription(Long shopsiteId, String contactEmail, ShopsiteReportSubscription.ReportType reportType, String complementary);

    void subscribe(ShopsiteReportSubscription subscription);

    void unsubscribe(ShopsiteReportSubscription subscription);

    List<ShopsiteReportSubscription> findSubscriptionsOfNLastMinutes(int nLastMinutes);

    void deleteSubscriptionReportForShopsiteAndType(Long shopsiteId, String reportType);

    void deleteObsoletePricingSubscription();
    
    void deleteObsoletePricingSubscriptionReportsAndAlerts(List<ShopsiteReportSubscription> shopsiteReportsSubscription);

	List<ShopsiteReportSubscription> findObsoletePricingSubscription();

}
