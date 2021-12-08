package com.leguide.backoffice.karaf.webservices.offercategorization.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;


/**
 * WS OfferCatgorization Route
 */
public class OfferCategorizationRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
		
		onException(Exception.class).handled(true)
			.removeHeader("Content-Length")
			.setHeader(Exchange.HTTP_RESPONSE_CODE, constant("400"))
			.marshal().json(JsonLibrary.Jackson)
			.setHeader("Content-Type", constant("application/json"))
			.log("EXCEPTION OCCURED!!! " + simple("${exception.stacktrace}").getText());

        from("cxfrs:bean:rsServer?bindingStyle=SimpleConsumer&synchronous=true")
        .routeId("categorization")
        .log("utilisation de l addon categorization. Appel de la méthode : ${header.operationName}")
        .recipientList(simple("direct:${header.operationName}"));

        from("direct:getCategorizationOffers")
        .routeId("getCategorizationOffers")
        .beanRef("offerCategorizationProcessor", "getCategorizationOffers")
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("200"));

        from("direct:saveCategoryOffer")
        .routeId("saveCategoryOffer")
        .beanRef("offerCategorizationProcessor", "saveCategoryOffer")
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("200"));
    }
}
