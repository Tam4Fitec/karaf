package com.leguide.backoffice.karaf.bundle.business.catalog.offercount.bean;

import org.apache.camel.Header;
import org.springframework.util.StringUtils;

import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.utils.Headers;

public class Validation {

    /**
     * Validate that all data are ok before calling the search_engine
     * @param shopId
     * @param country a ISO country code on 2 char
     * @param catalogId
     * @return true if shop_id not null and > 0, country not null and length = 2, catalogId not null and > 0
     */
    public boolean validateData(@Header(Headers.SHOP_ID) Long shopId, @Header(Headers.COUNTRY) String country,
            @Header(Headers.CATALOG_ID) Long catalogId) {
        return (shopId != null && shopId > 0)
                && (StringUtils.hasLength(country) && country.length() == 2)
                && (catalogId != null && catalogId > 0);
    }

    /**
     * Validate total_offer before save in DB
     * @param total
     * @return true if not null and >= 0
     */
    public boolean validateTotalOffer(@Header(Headers.TOTAL_OFFER_COUNT) Long total) {
        return total != null && total >= 0l;
    }
}
