package com.leguide.backoffice.karaf.bundle.business.catalog.offercount.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.pojo.UpdatePojo;

/**
 * Aggregation strategy: aggregate Pojo to a List<Pojo>
 * @author jlboulanger
 *
 */
public class CatalogAggregationStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        //first exchange
        if (oldExchange == null) {
            List<UpdatePojo> body = new ArrayList<UpdatePojo>();
            UpdatePojo pojo = newExchange.getIn().getBody(UpdatePojo.class);
            body.add(pojo);
            newExchange.getIn().setBody(body);
            return newExchange;
        }
        if (newExchange == null) {
            return oldExchange;
        }
        UpdatePojo pojo = newExchange.getIn().getBody(UpdatePojo.class);
        oldExchange.getIn().getBody(List.class).add(pojo);
        return oldExchange;
    }

}
