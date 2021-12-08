package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.response;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/*
 * Created by stephane.ben-zakoun on 12/06/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private OfferResponse offerResponse;

    private List<FacetResponseElement> facetResponse;

    private List<GroupOfferResponse> groupOfferResponse;

    public OfferResponse getOfferResponse() {
        return offerResponse;
    }

    public void setOfferResponse(OfferResponse offerResponse) {
        this.offerResponse = offerResponse;
    }

    public List<FacetResponseElement> getFacetResponse() {
        return facetResponse;
    }

    public void setFacetResponse(List<FacetResponseElement> facetResponse) {
        this.facetResponse = facetResponse;
    }

    public List<GroupOfferResponse> getGroupOfferResponse() {
        return groupOfferResponse;
    }

    public void setGroupOfferResponse(List<GroupOfferResponse> groupOfferResponse) {
        this.groupOfferResponse = groupOfferResponse;
    }
}
