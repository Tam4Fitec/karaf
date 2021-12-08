package com.leguide.backoffice.karaf.webservice.client.webs.model.product.request;

import com.leguide.backoffice.karaf.webservice.client.webs.Utils;
import com.leguide.backoffice.karaf.webservice.client.webs.exception.InvalidWebsRequestException;
import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.AbstractRequestParameter;
import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.AbstractWebsRequest;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.LangEnum;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.SearchOffersParameters;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.WebSOfferField;

import java.util.Collection;
import java.util.HashMap;
import java.util.StringJoiner;

/*
 * Created by stephane.ben-zakoun on 22/05/17.
 */
public class WebSProductRequestUsingKsite extends AbstractWebsRequest {


    public WebSProductRequestUsingKsite(String host, String port, String lang, String siteId, String productId) throws InvalidWebsRequestException {
        this.host=host;
        this.port=port;
        parameters = new HashMap<>();
        LangEnum langEnum = LangEnum.getValueOf(lang);
        if(langEnum==null){
            throw new InvalidWebsRequestException(lang + " is not a valid lang for search engine webs");
        }
        else if(this.host==null || this.host.length()==0){
            throw new InvalidWebsRequestException("host parameter is not defined");
        }
        else if(!Utils.isAnInteger(port)){
            throw new InvalidWebsRequestException("port parameter is not a number");
        }
        else if(productId==null || productId.length()==0){
            throw new InvalidWebsRequestException("productId is not valid");
        }

        parameters.put(WebSProductField.LANG, new RequestParameter<>(WebSProductField.LANG,true, langEnum));
        parameters.put(WebSProductField.KSITE, new RequestParameter<>(WebSProductField.KSITE,true, siteId));
        parameters.put(WebSProductField.PRODUCT_ID, new RequestParameter<>(WebSProductField.PRODUCT_ID, true, productId));
    }

    public void addParameter(WebSOfferField field, Object value){
        parameters.put(field, new RequestParameter<>(field, field.isMandatory(), value));
    }

    @Override
    public String buildQuery() {
        String prefix = host + ":" + port +  "/webs/api/1.0/offer/search/lang/" + parameters.get(WebSOfferField.LANG).getValueStr()
                + "/ksite/" + parameters.get(WebSOfferField.KSITE).getValueStr() + "?";


        StringJoiner sj = new StringJoiner("&", prefix, "");

        Collection<AbstractRequestParameter> parametersUsed = parameters.values();
        parametersUsed.stream().filter(parameter -> !parameter.getField().getValue().equals(SearchOffersParameters.SITE_ID) && !parameter.getField().getValue().equals(SearchOffersParameters.LANG))
                .forEach(param -> sj.add(param.getField().getValue() +"="+param.getValueStr()));

        return sj.toString();
    }
}
