package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.response;

import com.leguide.backoffice.karaf.webservice.client.webs.model.common.response.WebSResponse;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by stephane.ben-zakoun on 12/06/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebSOfferResponse extends WebSResponse {

    private ResponseHeader responseHeader;

    private Response response;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }


    public int getNbOffers() {

        OfferResponse offerResponse = response!=null ? response.getOfferResponse() : null;
        return offerResponse!=null ? offerResponse.getMatch() :  -1;
    }

    public int getNbShops() {
        OfferResponse offerResponse = response!=null ? response.getOfferResponse() : null;
        return offerResponse!=null ? offerResponse.getMatch_shops() : -1;
    }

    public int getNbGroupings() {

        List<GroupOfferResponse> groupOfferResponseList =response!=null ?response.getGroupOfferResponse() : new ArrayList<>();

        return groupOfferResponseList.size();
    }
}
