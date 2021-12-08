package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request;

import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.AbstractRequestParameter;
import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.WebSFieldInterface;
import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.WebSTypeFieldInterface;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.ShuffleSortType;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.SortType;

public class RequestParameter<TYPE> extends AbstractRequestParameter<TYPE>{


    public RequestParameter(WebSFieldInterface name, boolean mandatory) {
        super(name, mandatory);
    }

    public RequestParameter(WebSFieldInterface name, boolean mandatory, TYPE value) {
        super(name, mandatory, value);
    }

    public String getValueStr() {

        String valueStr = super.getValueStr();

        if(valueStr==null){
            if(value instanceof WebSTypeFieldInterface){
                return ((WebSTypeFieldInterface) value).getValue();
            }
            else if(value instanceof SortType){
                return ((SortType) value).getValue();
            }
            else if(value instanceof ShuffleSortType){
                return ((ShuffleSortType) value).getValue();
            }
            return null;
        }
        else{
            return valueStr;
        }
    }

}
