package com.leguide.backoffice.karaf.bundle.business.catalog.offercount.route;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;

import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.utils.Headers;

public class EntryPoint extends RouteBuilder {
    
    @Value("${cron.expression}")
    private String cronValue;

    public String getCronValue() {
        return cronValue;
    }

    public void setCronValue(String cronValue) {
        this.cronValue = cronValue;
    }

    @Override
    public void configure() throws Exception {
        from("quartz2://catalog/offercount?cron=" + cronValue.replace(' ', '+') + "&job.name=offercount-provisioning")
            .routeId("quartz-catalog.offercount")
            .setHeader(Headers.KSITE, constant(2))
            .to("seda:getOffers");
        
        from("cxfrs:bean:rsCatalogOfferCount?bindingStyle=SimpleConsumer&synchronous=true")
            .routeId("wsemailling-cxfrscatalog.offercount")
            .recipientList(simple("direct:${header.operationName}"));
        
        from("direct:updateByShopsite").routeId("cxf-catalog.offercount-updateByShopsite")
            .log(LoggingLevel.DEBUG, "${body} and ${headers}")
            .wireTap("direct:getOffersByShopsiteId")
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
        
        from("direct:updateForAllShopsite").routeId("cxf-catalog.offercount-updateForAllShopsite")
            .log(LoggingLevel.DEBUG, "${body} and ${headers}")
            .wireTap("seda:getOffers")
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));

    }

}
