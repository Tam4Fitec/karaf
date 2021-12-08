package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type;


import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.WebSTypeFieldInterface;

public enum SortType implements WebSTypeFieldInterface {

    PRICE_ASC("price asc"), PRICE_DESC("price desc"), PRICE_TOTAL_ASC("price_total asc"),
    PRICE_TOTAL_DESC("price_total desc"), POPU("popu");

    private String value;

    SortType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
