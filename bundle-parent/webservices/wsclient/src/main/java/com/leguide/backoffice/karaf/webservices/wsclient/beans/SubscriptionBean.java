package com.leguide.backoffice.karaf.webservices.wsclient.beans;

import com.leguide.backoffice.karaf.bundle.dao.facade.ShopsiteSubscriptionReportDao;
import com.leguide.backoffice.karaf.business.models.pojo.subscription.ShopsiteReportSubscription;
import com.leguide.backoffice.karaf.webservices.wsclient.models.Subscription;
import org.apache.camel.Exchange;

public class SubscriptionBean {

    private ShopsiteSubscriptionReportDao shopsiteSubscriptionReportDao;

    public Subscription getSubscriptionStatsClicks(Exchange exchange) {
        exchange.getIn().setHeader("reportType", ShopsiteReportSubscription.ReportType.STATSCLICKS);
        return getSubscription(exchange);
    }

    public Subscription getSubscriptionPurchase(Exchange exchange) {
        exchange.getIn().setHeader("reportType", ShopsiteReportSubscription.ReportType.PURCHASE);
        return getSubscription(exchange);
    }

    private Subscription getSubscription(Exchange exchange) {
        Long shopsiteId = exchange.getIn().getHeader("shopsiteId", Long.class);
        String contactEmail = exchange.getIn().getHeader("contactEmail", String.class);
        ShopsiteReportSubscription.ReportType reportType = exchange.getIn().getHeader("reportType", ShopsiteReportSubscription.ReportType.class);

        ShopsiteReportSubscription shopsiteReportSubscription = shopsiteSubscriptionReportDao.findShopsiteReportSubscription(shopsiteId, contactEmail, reportType);

        if (shopsiteReportSubscription != null) {
            return new Subscription(shopsiteReportSubscription.getContactEmail(), shopsiteReportSubscription.getPeriod());
        } else {
            return null;
        }
    }

    public void subscribeToReportStatsClicks(Exchange exchange) {
        exchange.getIn().setHeader("reportType", ShopsiteReportSubscription.ReportType.STATSCLICKS);
        subscribeToReport(exchange);
    }

    public void subscribeToReportPurchase(Exchange exchange) {
        exchange.getIn().setHeader("reportType", ShopsiteReportSubscription.ReportType.PURCHASE);
        subscribeToReport(exchange);
    }

    private void subscribeToReport(Exchange exchange) {
        Long shopsiteId = exchange.getIn().getHeader("shopsiteId", Long.class);
        Subscription subscription = exchange.getIn().getBody(Subscription.class);
        ShopsiteReportSubscription.ReportType reportType = exchange.getIn().getHeader("reportType", ShopsiteReportSubscription.ReportType.class);
        ShopsiteReportSubscription shopsiteReportSubscription = new ShopsiteReportSubscription(shopsiteId, subscription.getContactEmail(), subscription.getPeriod(),
                reportType, "");

        shopsiteSubscriptionReportDao.subscribe(shopsiteReportSubscription);
    }

    public void unsubscribeToReportStatsClicks(Exchange exchange) {
        exchange.getIn().setHeader("reportType", ShopsiteReportSubscription.ReportType.STATSCLICKS);
        unsubscribeToReport(exchange);
    }

    public void unsubscribeToReportPurchase(Exchange exchange) {
        exchange.getIn().setHeader("reportType", ShopsiteReportSubscription.ReportType.PURCHASE);
        unsubscribeToReport(exchange);
    }

    private void unsubscribeToReport(Exchange exchange) {
        Long shopsiteId = exchange.getIn().getHeader("shopsiteId", Long.class);
        Subscription subscription = exchange.getIn().getBody(Subscription.class);
        ShopsiteReportSubscription.ReportType reportType = exchange.getIn().getHeader("reportType", ShopsiteReportSubscription.ReportType.class);
        ShopsiteReportSubscription shopsiteReportSubscription = new ShopsiteReportSubscription(shopsiteId, subscription.getContactEmail(), subscription.getPeriod(),
                reportType, "");

        shopsiteSubscriptionReportDao.unsubscribe(shopsiteReportSubscription);
    }

    public ShopsiteSubscriptionReportDao getShopsiteSubscriptionReportDao() {
        return shopsiteSubscriptionReportDao;
    }

    public void setShopsiteSubscriptionReportDao(ShopsiteSubscriptionReportDao shopsiteSubscriptionReportDao) {
        this.shopsiteSubscriptionReportDao = shopsiteSubscriptionReportDao;
    }
}
