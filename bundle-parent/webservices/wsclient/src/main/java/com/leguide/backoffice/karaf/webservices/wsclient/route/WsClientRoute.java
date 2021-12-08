package com.leguide.backoffice.karaf.webservices.wsclient.route;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
import com.leguide.backoffice.karaf.bundle.dao.facade.ShopsiteQuery;
import com.leguide.backoffice.karaf.business.models.pojo.contact.Contact;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.ShopSite;
import com.leguide.backoffice.karaf.webservices.wsclient.models.Balance;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * WS Client Route
 *
 * @mdarcemont
 */
public class WsClientRoute extends RouteBuilder {

    @Override
    @SuppressWarnings(value = "unchecked")
    public void configure() throws Exception {

        CsvDataFormat csv = new CsvDataFormat();
        csv.setDelimiter(";");

        onException(Exception.class)
                .handled(true)
                .removeHeader("Content-Length")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("400"))
                .marshal().json(JsonLibrary.Jackson)
                .setHeader("Content-Type", constant("application/json"));

        from("cxfrs:bean:rsServer?bindingStyle=SimpleConsumer&synchronous=true")
                .routeId("client-ws-main")
                .recipientList(simple("direct:${header.operationName}"));

        from("direct:getConsumption")
                .routeId("client-ws-get-consumption")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        exchange.getIn().setHeader("currentDate", new Date());
                    }
                })
                .beanRef("shopsiteConsumptionDao", "findByStoreFromDate(${headers.shopsiteId}, ${headers.currentDate})")
                .beanRef("shopsiteConsumptionAdapter", "adaptToConsumptionList")
                .marshal().json(JsonLibrary.Jackson)
                .setHeader("Content-Type", constant("application/json"));

        from("direct:updateConsumption")
                .routeId("client-ws-update-max-consumption")
                .setHeader("month", simple("${body.month}"))
                .setHeader("maximumAmount", simple("${body.maximumAmount}"))
                .beanRef("shopsiteConsumptionAdapter", "adaptToShopsiteConsumption")
                .beanRef("validationBean", "validateMaximumConsumption")
                .beanRef("shopsiteConsumptionDao", "update")
                .beanRef("shopsiteConsumptionBean", "updateShopsiteState")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("204"))
                .filter(header("currentUserEmail").isNotNull())
                .enrich("direct:retrieveContactsEmailsForShopsite", new AggregationStrategy() {
                    @Override
                    public Exchange aggregate(Exchange exchange, Exchange exchange2) {
                        exchange.getIn().setHeader("recipients", exchange2.getIn().getBody(String.class));
                        return exchange;
                    }
                })
                .enrich("direct:retrieveShopsite", new AggregationStrategy() {
                    @Override
                    public Exchange aggregate(Exchange exchange, Exchange exchange2) {
                        ShopSite shopSite = exchange2.getIn().getBody(ShopSite.class);
                        exchange.getIn().setHeader("language", shopSite.getLanguage());
                        exchange.getIn().setHeader("url", shopSite.getUrl());
                        return exchange;
                    }
                })
                .beanRef("sendEmailBean", "sendEmailAlertConsumption");

        from("direct:findLastInvoices")
                .routeId("client-ws-find-last-invoices")
                .beanRef("invoiceDao", "findLastInvoices(${headers.clientId})")
                .beanRef("enrichInvoiceBean")
                .marshal().json(JsonLibrary.Jackson)
                .setHeader("Content-Type", constant("application/json"));

        from("direct:getBalance")
                .routeId("client-ws-get-balance")
                .beanRef("ecritureDao", "getBalance(${headers.clientId})")
                .process(new Processor() {

                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Double dBalance = (Double) exchange.getIn().getBody();
                        if (dBalance == null)
                            dBalance = new Double(0);
                        Balance newBalance = new Balance(dBalance);
                        exchange.getIn().setBody(newBalance);
                    }
                })
                .marshal().json(JsonLibrary.Jackson)
                .setHeader("Content-Type", constant("application/json"));

        from("direct:getShopsiteFeeds")
                .routeId("client-ws-get-shopsite-feeds")
                .beanRef("shopsiteFeedsBean", "getShopsiteFeeds")
                .marshal().json(JsonLibrary.Jackson)
                .setHeader("Content-Type", constant("application/json"));

        from("direct:findCurrentShopsitePurchase")
                .routeId("client-ws-find-current-purchase")
                .beanRef("shopsitePurchaseDao", "findShopsiteCurrentPurchase(${headers.shopsiteId})")
                .beanRef("shopsitePurchaseAdapter")
                .marshal().json(JsonLibrary.Jackson)
                .setHeader("Content-Type", constant("application/json"));

        from("direct:getSubscriptionStatsClicks")
                .routeId("client-ws-get-subscription-statsclicks")
                .beanRef("subscriptionBean", "getSubscriptionStatsClicks")
                .choice()
                .when(body().isNotNull())
                .marshal().json(JsonLibrary.Jackson)
                .setHeader("Content-Type", constant("application/json"))
                .otherwise()
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("404"))
                .endChoice();

        from("direct:getSubscriptionPurchase")
                .routeId("client-ws-get-subscription-purchase")
                .beanRef("subscriptionBean", "getSubscriptionPurchase")
                .choice()
                .when(body().isNotNull())
                .marshal().json(JsonLibrary.Jackson)
                .setHeader("Content-Type", constant("application/json"))
                .otherwise()
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("404"))
                .endChoice();

        from("direct:subscribeToReportStatsClicks")
                .routeId("client-ws-subscribe-to-report-statsclicks")
                .beanRef("subscriptionBean", "subscribeToReportStatsClicks")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("204"));

        from("direct:subscribeToReportPurchase")
                .routeId("client-ws-subscribe-to-report-purchase")
                .beanRef("subscriptionBean", "subscribeToReportPurchase")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("204"));

        from("direct:unsubscribeToReportStatsClicks")
                .routeId("client-ws-unsubscribe-to-report-statsclicks")
                .beanRef("subscriptionBean", "unsubscribeToReportStatsClicks")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("204"));

        from("direct:unsubscribeToReportPurchase")
                .routeId("client-ws-unsubscribe-to-report-purchase")
                .beanRef("subscriptionBean", "unsubscribeToReportPurchase")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("204"));

        from("direct:getEcritures")
                .routeId("client-ws-get-ecritures")
                .beanRef("ecritureDao", "getEcrituresForExport(${headers.clientId})")
                .marshal(csv)
                .setHeader("Content-Type", constant("text/csv"))
                .setHeader("Content-Disposition", simple("attachment; filename=ecrituresComptable_${headers.clientId}.csv"));

        from("direct:retrieveContactsEmailsForShopsite")
                .routeId("client-ws-retrieve-contacts-emails-for-shopsite")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        exchange.getIn().setHeader("roles", Arrays.asList(2));
                    }
                })
                .beanRef("contactDao", "findAllByShopsiteAndRoles(${headers.shopsiteId}, ${headers.roles})")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String currentUserEmail = exchange.getIn().getHeader("currentUserEmail", String.class);
                        List<Contact> contacts = exchange.getIn().getBody(List.class);

                        // Generate contacts emails list
                        Set<String> emails = FluentIterable
                                .from(contacts)
                                // Get a email list from a contact list
                                .transform(new Function<Contact, String>() {
                                    @Override
                                    public String apply(Contact contact) {
                                        return contact.getEmail();
                                    }
                                })
                                // Filter, remove invalid emails
                                .filter(new Predicate<String>() {
                                    @Override
                                    public boolean apply(String email) {
                                        boolean result = true;
                                        try {
                                            InternetAddress emailAddr = new InternetAddress(email);
                                            emailAddr.validate();
                                        } catch (AddressException ex) {
                                            result = false;
                                        }
                                        return result;
                                    }
                                })
                                .toSet();

                        // Full list, with current user email
                        Set<String> allEmails = new ImmutableSet.Builder<String>()
                                .addAll(emails)
                                .add(currentUserEmail)
                                .build();

                        // Comma-separated emails list
                        String emailsCommaSeparated = Joiner.on(",").join(allEmails);
                        exchange.getIn().setBody(emailsCommaSeparated);
                    }
                });

        from("direct:retrieveShopsite")
                .routeId("client-ws-retrieve-url-of-shopsite")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        exchange.getIn().setHeader("shopsiteQuery", new ShopsiteQuery.Builder());
                    }
                })
                .beanRef("shopSiteService", "findById(${headers.shopsiteId}, ${headers.shopsiteQuery})");
    }
}
