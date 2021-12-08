package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request;

import com.leguide.backoffice.karaf.webservice.client.webs.Utils;
import com.leguide.backoffice.karaf.webservice.client.webs.exception.InvalidWebsRequestException;
import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.AbstractRequestParameter;
import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.AbstractWebsRequest;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.LangEnum;

import java.util.Collection;
import java.util.HashMap;
import java.util.StringJoiner;

/*
 * Created by stephane.ben-zakoun on 22/05/17.
 */
public class WebSOffersRequestWithSiteId extends AbstractWebsRequest {

    public WebSOffersRequestWithSiteId(String host, String port, String lang, String siteId) throws InvalidWebsRequestException {
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

        parameters.put(WebSOfferField.LANG, new RequestParameter<>(WebSOfferField.LANG,true, langEnum));
        parameters.put(WebSOfferField.SITE_ID, new RequestParameter<>(WebSOfferField.SITE_ID,true, siteId));
    }

    public void addParameter(WebSOfferField field, Object value){

        parameters.put(field, new RequestParameter<>(field, field.isMandatory(), value));

    }

    @Override
    public String buildQuery(){

        String prefix = host + ":" + port +  "/webs/api/1.0/offer/search/lang/" + parameters.get(WebSOfferField.LANG).getValueStr()
                             + "/site-id/" + parameters.get(WebSOfferField.SITE_ID).getValueStr() + "?";


        StringJoiner sj = new StringJoiner("&", prefix, "");

        Collection<AbstractRequestParameter> parametersUsed = parameters.values();
        parametersUsed.stream().filter(parameter -> !parameter.getField().getValue().equals(SearchOffersParameters.SITE_ID) && !parameter.getField().getValue().equals(SearchOffersParameters.LANG))
                               .forEach(param -> sj.add(param.getField().getValue() +"="+param.getValueStr()));

        return sj.toString();
    }

}
