package com.leguide.backoffice.karaf.webservices.wsclient.beans;

import com.leguide.backoffice.karaf.bundle.dao.facade.ShopsiteConsumptionDao;
import com.leguide.backoffice.karaf.business.error.JsonError;
import com.leguide.backoffice.karaf.business.error.JsonFieldError;
import com.leguide.backoffice.karaf.business.models.pojo.consumption.ShopsiteConsumption;
import org.apache.camel.Exchange;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by manuel on 3/28/14.
 */
public class ValidationBean {

    private ShopsiteConsumptionDao shopsiteConsumptionDao;

    public void validateMaximumConsumption(Exchange exchange) throws IllegalArgumentException {
        ShopsiteConsumption sc = exchange.getIn().getBody(ShopsiteConsumption.class);
        Optional<ShopsiteConsumption> oldSc = shopsiteConsumptionDao.findByStoreAtDate(sc.getStoreUid(), sc.getStartDate());
        if(oldSc.isPresent()) {
            if (sc.getMaximumAmount() <= oldSc.get().getMaximumAmount()) {
                processError(exchange);
            }
        } else {
            processError(exchange);
        }
    }

    private void processError(Exchange exchange) throws IllegalArgumentException {
        JsonFieldError jsonFieldError = new JsonFieldError("maximumAmount", "Le nouveau plafond doit être supérieur au plafond actuel.");
        JsonError jsonError = new JsonError("Opération refusée", Arrays.asList(jsonFieldError));
        exchange.getIn().setBody(jsonError);
        throw new IllegalArgumentException();
    }

    public ShopsiteConsumptionDao getShopsiteConsumptionDao() {
        return shopsiteConsumptionDao;
    }

    public void setShopsiteConsumptionDao(ShopsiteConsumptionDao shopsiteConsumptionDao) {
        this.shopsiteConsumptionDao = shopsiteConsumptionDao;
    }
}
