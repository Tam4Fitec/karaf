package com.leguide.backoffice.karaf.webservices.wsclient.beans;

import com.leguide.backoffice.karaf.business.models.pojo.consumption.ShopsiteConsumption;
import com.leguide.backoffice.karaf.webservices.wsclient.models.Consumption;
import org.apache.camel.Exchange;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ShopsiteConsumptionAdapter {

    private SimpleDateFormat formatter = new SimpleDateFormat("MM-yyyy");

    public List<Consumption> adaptToConsumptionList(List<ShopsiteConsumption> listCsc) {
        List<Consumption> listSc = new ArrayList<Consumption>();
        for (ShopsiteConsumption csc : listCsc) {
            listSc.add(adaptToConsumption(csc));
        }
        return listSc;
    }

    public Consumption adaptToConsumption(ShopsiteConsumption csc) {
        return new Consumption(formatter.format(csc.getStartDate()), csc.getCurrentAmount(), csc.getMaximumAmount());
    }

    public ShopsiteConsumption adaptToShopsiteConsumption(Exchange exchange) throws ParseException {
        Consumption sc = exchange.getIn().getBody(Consumption.class);
        Long shopsiteId = exchange.getIn().getHeader("shopsiteId", Long.class);

        ShopsiteConsumption csc = new ShopsiteConsumption();
        csc.setStoreUid(shopsiteId);
        csc.setMaximumAmount(sc.getMaximumAmount());
        csc.setStartDate(formatter.parse(sc.getMonth()));
        csc.setAmountAlert("NONE");

        return csc;
    }

}
