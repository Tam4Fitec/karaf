package com.leguide.backoffice.karaf.webservices.wsclient.beans;

import com.leguide.backoffice.karaf.business.models.pojo.consumption.ShopsitePurchase;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;

public class ShopsitePurchaseAdapter {

    private Logger logger = LoggerFactory.getLogger(ShopsitePurchaseAdapter.class);

    /**
     * Formats the average cpc
     *
     * @param exchange
     * @throws ParseException
     */
    public void adapt(Exchange exchange) throws ParseException {
        ShopsitePurchase sp = exchange.getIn().getBody(ShopsitePurchase.class);
        if (sp.getAvgCpc() != null) {
            BigDecimal bd = new BigDecimal(sp.getAvgCpc());
            bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
            sp.setAvgCpc(bd.doubleValue());
        }
        if (sp.getMaximumAmount() != null) {
            BigDecimal bd = new BigDecimal(sp.getMaximumAmount());
            bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
            sp.setMaximumAmount(bd.doubleValue());
        } else {
            sp.setMaximumAmount(0.0);
        }
        exchange.getIn().setBody(sp);
    }
}
