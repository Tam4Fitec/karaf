package com.leguide.backoffice.karaf.bundle.business.catalog.offercount.route;

import static org.apache.camel.builder.PredicateBuilder.and;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.util.StringUtils;

import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.bean.CatalogAggregationStrategy;
import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.pojo.UpdatePojo;
import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.utils.Headers;

public class OfferCountRoute extends RouteBuilder {

    @Value("${catalog.seda.offercount.consumers}")
    private int sedaCConsumersOffer;

    @Override
    public void configure() throws Exception {

        from("direct:getOffersByShopsiteId").routeId("catalog.offercount-byshopsiteId")
            .log(LoggingLevel.DEBUG, "${body} and ${headers}")
            //process only if shopsite is there
            .filter(and(header(Headers.SHOPSITE_ID), header(Headers.KSITE)))
            //enrich with catalogId
            .enrich("direct:enrichWithCatalogId", new AggregationStrategy() {
                
                @Override
                public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
                    Long newBody = newExchange.getIn().getBody(Long.class);
                    UpdatePojo pojo = new UpdatePojo();
                    pojo.setIdCatalog(newBody);
                    pojo.setIdshopsite(oldExchange.getIn().getHeader(Headers.SHOPSITE_ID, Long.class));
                    oldExchange.getIn().setHeader(Headers.CATALOG_ID, newBody);
                    oldExchange.getIn().setBody(pojo, UpdatePojo.class);
                    return oldExchange;
                }
            })
            .to("seda:enrich")
        ;

        from("seda:getOffers?waitForTaskToComplete=Never").routeId("catalog.offercount-shopstategt0")
            .beanRef("catalogDao", "shopStateGt0").split(body(List.class)).streaming().parallelProcessing()
            .log(LoggingLevel.DEBUG, "${body} and ${headers}")
            .setHeader(Headers.SHOPSITE_ID, simple("${body.idshopsite}"))
            .setHeader(Headers.CATALOG_ID, simple("${body.idCatalog}"))
            .to("seda:enrich")
        ;

        from("seda:enrich?waitForTaskToComplete=Never").routeId("catalog.offercount-enrich")
            .log(LoggingLevel.DEBUG, "${body} and ${headers}")
            //process only if catalog, shopsite and ksite are there
            //enrich with shop_id and country
            .enrich("direct:enrichWithStoreIdAndCountry", new AggregationStrategy() {
                
                @Override
                public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
                    String newBody = newExchange.getIn().getBody(String.class);
                    Long shopId = null;
                    String country = null;
                    if (StringUtils.hasLength(newBody) && newBody.split("@").length == 2) {
                        shopId = Long.valueOf(newBody.split("@")[0]);
                        country = newBody.split("@")[1].toUpperCase();
                    }
                    oldExchange.getIn().setHeader(Headers.SHOP_ID, shopId);
                    oldExchange.getIn().setHeader(Headers.COUNTRY, country);
                    return oldExchange;
                }
            })
            //enrich with offer count if all headers are set
            .filter(method("validationFilter", "validateData"))
            .to("seda:enrichWithTotalOfferCount")
            ;

        from("direct:enrichWithStoreIdAndCountry").routeId("catalog.offercount-enrich-storeidAndCountry")
            .removeHeaders("Camel*")
            .onException(EmptyResultDataAccessException.class)
                .handled(true).logHandled(false).setBody(constant(null)).end()
            .log(LoggingLevel.DEBUG, "calling enrich storeid with ${headers." + Headers.SHOPSITE_ID +"}")
            .beanRef("enrichBean", "enrichWithShopIdAndCountry")
            ;

        from("direct:enrichWithCatalogId").routeId("catalog.offercount-enrich-catalogid")
            .removeHeaders("Camel*")
            .onException(EmptyResultDataAccessException.class)
                .handled(true).logHandled(false).setBody(constant(null)).end()
            .log(LoggingLevel.DEBUG, "calling enrich catalog id with ${headers." + Headers.SHOPSITE_ID +"}")
            .beanRef("enrichBean", "enrichWithCatalogId")
            ;
        
        from("seda:enrichWithTotalOfferCount?concurrentConsumers=" + sedaCConsumersOffer).routeId("catalog.offercount-enrich-total-count")
            .log(LoggingLevel.DEBUG, "calling enrich total offers with ${headers}")
            .beanRef("enrichBean", "enrichWithTotalOffer")
            .setHeader(Headers.AGGREGATION_HEADER, constant(Headers.AGGREGATION_HEADER))
            .to("direct:aggregation")
            ;

        from("direct:aggregation").routeId("catalog.offercount-aggregation")
            .filter(method("validationFilter", "validateTotalOffer"))
            .aggregate(header(Headers.AGGREGATION_HEADER), new CatalogAggregationStrategy())
            .completionSize(constant(500)).completionTimeout(constant(20000))
            .beanRef("catalogDao", "batchUpdateOfferCount")
            ;
                
    }

    public int getSedaCConsumersOffer() {
        return sedaCConsumersOffer;
    }

    public void setSedaCConsumersOffer(int sedaCConsumersOffer) {
        this.sedaCConsumersOffer = sedaCConsumersOffer;
    }

}
