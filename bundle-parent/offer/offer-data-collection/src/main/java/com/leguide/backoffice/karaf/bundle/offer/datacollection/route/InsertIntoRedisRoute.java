package com.leguide.backoffice.karaf.bundle.offer.datacollection.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

/**
 * InsertIntoRedisRoute
 */
public class InsertIntoRedisRoute extends RouteBuilder {


	
	@Override
    public void configure() {

	
        from("hazelcast:seda:offer?concurrentConsumers=10&pollInterval=500")
            .routeId("business.offer.pixel-reception")
            .log(LoggingLevel.DEBUG, "[Offer][Business] Pixel Tracked received")
            .beanRef("redisBean", "incrementOfferHits")
		    .end();
    }

}
