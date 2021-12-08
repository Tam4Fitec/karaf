package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type;

import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.WebSTypeFieldInterface;

public enum ShuffleSortType implements WebSTypeFieldInterface {

    SHUFFLE_OPS("shuffle-ops"), SHUFFLE_DEDULICATED_OPS("shuffle-deduplicated-ops"), RANDOM("random");

    private String value;

    ShuffleSortType(String value) {
            this.value = value;
        }

    @Override
    public String getValue() {
        return value;
    }
}
