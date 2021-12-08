package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.response;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupOfferResponse {

    private String ean13;

    private String product;

    private String manuf;

    private float min_price;

    private float max_price;


    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getManuf() {
        return manuf;
    }

    public void setManuf(String manuf) {
        this.manuf = manuf;
    }

    public float getMin_price() {
        return min_price;
    }

    public void setMin_price(float min_price) {
        this.min_price = min_price;
    }

    public float getMax_price() {
        return max_price;
    }

    public void setMax_price(float max_price) {
        this.max_price = max_price;
    }
}
