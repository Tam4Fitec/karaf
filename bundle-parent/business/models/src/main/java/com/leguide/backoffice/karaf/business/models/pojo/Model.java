package com.leguide.backoffice.karaf.business.models.pojo;

import java.io.Serializable;
import java.util.Date;

public abstract class Model implements Serializable {
	
	private static final long serialVersionUID = -8462763944580413341L;


    private String salesforceId;

    public String getSalesforceId() {
        return salesforceId;
    }

    public void setSalesforceId(String salesforceId) {
        this.salesforceId = salesforceId;
    }
}
