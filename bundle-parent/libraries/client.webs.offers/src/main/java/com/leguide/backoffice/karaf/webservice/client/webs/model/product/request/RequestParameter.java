package com.leguide.backoffice.karaf.webservice.client.webs.model.product.request;

import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.AbstractRequestParameter;
import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.WebSFieldInterface;

public class RequestParameter<TYPE> extends AbstractRequestParameter<TYPE>{


    public RequestParameter(WebSFieldInterface name, boolean mandatory) {
        super(name, mandatory);
    }

    public RequestParameter(WebSFieldInterface name, boolean mandatory, TYPE value) {
        super(name, mandatory, value);
    }

    public String getValueStr() {

       return super.getValueStr();

    }

}
