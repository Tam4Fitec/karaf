package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request;

import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.WebSFieldInterface;

public enum WebSOfferField implements WebSFieldInterface {

        LANG(SearchOffersParameters.LANG, true),
        SITE_ID(SearchOffersParameters.SITE_ID, true),
        KSITE(SearchOffersParameters.KSITE, true),
        WORDS(SearchOffersParameters.WORDS, false),
        START(SearchOffersParameters.START, false),
        ROWS(SearchOffersParameters.ROWS, false),
        SORT(SearchOffersParameters.SORT, false),
        FAC_CAT(SearchOffersParameters.FAC_CAT, false),
        FAC_CAT_LIMIT(SearchOffersParameters.FAC_CAT_LIMIT, false),
        FAC_SHOP(SearchOffersParameters.FAC_SHOP, false),
        FAC_SHOP_LIMIT(SearchOffersParameters.FAC_SHOP_LIMIT, false),
        FAC_BRAND(SearchOffersParameters.FAC_BRAND, false),
        FAC_BRAND_LIMIT(SearchOffersParameters.FAC_BRAND_LIMIT, false),
        FIL_BRANDS(SearchOffersParameters.FIL_BRANDS, false),
        FIL_CATS(SearchOffersParameters.FIL_CATS, false),
        FIL_SHOPS(SearchOffersParameters.FIL_SHOPS, false),
        FAC_PRICE(SearchOffersParameters.FAC_PRICE, false),
        FAC_PRICE_LIMIT(SearchOffersParameters.FAC_PRICE_LIMIT, false),
        VAL_PRICE_MIN(SearchOffersParameters.VAL_PRICE_MIN, false),
        VAL_PRICE_MAX(SearchOffersParameters.VAL_PRICE_MAX, false),
        FAC_INSTOCK(SearchOffersParameters.FAC_INSTOCK, false),
        FAC_PAYDELIV(SearchOffersParameters.FAC_PAYDELIV, false),
        FAC_ONSALE(SearchOffersParameters.FAC_ONSALE, false),
        VAL_INSTOCK(SearchOffersParameters.VAL_INSTOCK, false),
        VAL_PAYDELIV(SearchOffersParameters.VAL_PAYDELIV, false),
        VAL_ONSALE(SearchOffersParameters.VAL_ONSALE, false),
        DELIV(SearchOffersParameters.DELIV, false),
        FIL_SHOP_STATES(SearchOffersParameters.FIL_SHOP_STATES, false),
        FIL_SHOP_SORT(SearchOffersParameters.FIL_SHOP_SORT, false),
        ONLY_CAT(SearchOffersParameters.ONLY_CAT, false),
        FIL_PRODUCTS(SearchOffersParameters.FIL_PRODUCTS, false),
        SORT_OPT(SearchOffersParameters.SORT_OPT, false),
        PRODUCT_GROUP_LIMIT(SearchOffersParameters.PRODUCT_GROUP_LIMIT, false),
        TIME_ALLOWED(SearchOffersParameters.TIME_ALLOWED, false),
        HAS_EAN(SearchOffersParameters.HAS_EAN, false),
        HAS_BRAND(SearchOffersParameters.HAS_BRAND, false),
        MATCH_SHOPS(SearchOffersParameters.MATCH_SHOPS, false),
        TREE_CAT(SearchOffersParameters.TREE_CAT, false),
        FAC_FEATURES(SearchOffersParameters.FAC_FEATURES, false),
        FAC_FEATURES_LIMIT(SearchOffersParameters.FAC_FEATURES_LIMIT, false),
        FIL_EANS(SearchOffersParameters.FIL_EANS, false),
        GROUP_BY_MERCHANT(SearchOffersParameters.GROUP_BY_MERCHANT, false),
        MERCHANT_GROUP_LIMIT(SearchOffersParameters.MERCHANT_GROUP_LIMIT, false),
        OFFER_MERCHANT_GROUP_LIMIT(SearchOffersParameters.OFFER_MERCHANT_GROUP_LIMIT, false);


        public static WebSOfferField[] values = {
                LANG, SITE_ID, WORDS, START, ROWS, SORT, SORT_OPT, FAC_CAT, FAC_CAT_LIMIT, FAC_BRAND, FAC_BRAND_LIMIT,
                FAC_SHOP, FAC_SHOP_LIMIT, FIL_BRANDS, FIL_CATS, FIL_SHOPS, FAC_PRICE, FAC_PRICE_LIMIT, VAL_PRICE_MIN, VAL_PRICE_MAX,
                FAC_INSTOCK, FAC_PAYDELIV, FAC_ONSALE, VAL_INSTOCK, VAL_PAYDELIV, VAL_ONSALE, DELIV, FIL_SHOP_STATES, FIL_SHOP_SORT,
                ONLY_CAT, FIL_PRODUCTS, PRODUCT_GROUP_LIMIT, TIME_ALLOWED, HAS_EAN, HAS_BRAND, MATCH_SHOPS, TREE_CAT, FAC_FEATURES,
                FAC_FEATURES_LIMIT, FIL_EANS, GROUP_BY_MERCHANT, MERCHANT_GROUP_LIMIT, OFFER_MERCHANT_GROUP_LIMIT};

        public static WebSOfferField getByName(String value){

            for(WebSOfferField websField : values){
                if(websField.value.equals(value)){
                    return websField;
                }
            }
            return null;
        }

        private final String value;

        private final boolean mandatory;

        WebSOfferField(String value, boolean mandatory) {

            this.value = value;
            this.mandatory=mandatory;
        }

        public String getValue() {
            return value;
        }

        public boolean isMandatory() {return mandatory;}

}
