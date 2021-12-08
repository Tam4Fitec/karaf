package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.response;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/*
 * Created by stephane.ben-zakoun on 12/06/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferResponse {

    private int start;

    private int match;

    private int match_shops;

    private List<OfferValue> values;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public int getMatch_shops() {
        return match_shops;
    }

    public void setMatch_shops(int match_shops) {
        this.match_shops = match_shops;
    }

    public List<OfferValue> getValues() {
        return values;
    }

    public void setValues(List<OfferValue> values) {
        this.values = values;
    }
}
