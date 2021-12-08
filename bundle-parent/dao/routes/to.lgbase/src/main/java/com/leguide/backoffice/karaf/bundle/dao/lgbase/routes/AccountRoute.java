package com.leguide.backoffice.karaf.bundle.dao.lgbase.routes;

import com.leguide.backoffice.karaf.bundle.dao.lgbase.beans.MergingClient;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import static org.apache.camel.builder.PredicateBuilder.isNull;

public class AccountRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:create-or-update-client-from-sage-event")
                .routeId("client-sage-created-or-updated-route")
                .setHeader("client-from-event", simple("${body}"))
                .beanRef("lgClientDao", "findClient(${body.clientId})")
                .choice()
                .when(isNull(body()))
                .beanRef("lgClientDao", "create(${header.client-from-event})")
                .otherwise()
                .bean(MergingClient.class, "merge")
                .beanRef("lgClientDao", "update(${body})")
                .beanRef("lgClientDao", "defineAsSageSource(${body.clientId})")
                .marshal().json(JsonLibrary.Gson)
                .log("client merged : ${body}")
                .endChoice()
                .end();
    }
}
