package com.leguide.backoffice.karaf.webservice.client.webs.model.product.request;

import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.WebSFieldInterface;

public enum WebSProductField implements WebSFieldInterface {

        LANG(SearchProductParameters.LANG, true),
        SITE_ID(SearchProductParameters.SITE_ID, true),
        KSITE(SearchProductParameters.SITE_ID, true),
        ROWS(SearchProductParameters.ROWS, true),
        PRODUCT_ID(SearchProductParameters.PRODUCT_ID, true);

        public static WebSProductField[] values = {LANG, SITE_ID, ROWS, PRODUCT_ID};


        public static WebSProductField getByName(String value){

            for(WebSProductField websField : values){
                if(websField.value.equals(value)){
                    return websField;
                }
            }
            return null;
        }

        private final String value;

        private final boolean mandatory;

        WebSProductField(String value, boolean mandatory) {

            this.value = value;
            this.mandatory=mandatory;
        }

        public String getValue() {
            return value;
        }

        public boolean isMandatory() {return mandatory;}

}
