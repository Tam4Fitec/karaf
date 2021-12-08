package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type;

import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.WebSTypeFieldInterface;

public enum LangEnum implements WebSTypeFieldInterface {

    FR("fr"), DE("de"), ES("es"), IT("it"), NL("nl"), SE("se"), PL("pl"), DK("dk"), GB("gb");

    private String value;

    public static LangEnum[] values = {FR, DE, ES, IT, NL, SE, PL, DK, GB};

    public static LangEnum getValueOf(String lang){

        for(LangEnum langEnum : values()){
            if(langEnum.value.equals(lang)){
                return langEnum;
            }
        }
        return null;
    }

    LangEnum(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
