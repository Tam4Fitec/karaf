package com.leguide.backoffice.karaf.business.models.pojo;


public enum AccountStateEnum {

    // FREE
    FREE("FREE"),
    // PAYING
    PAYING("PAYING");

    final String value;

    private AccountStateEnum(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static AccountStateEnum fromValue(String value) {
        for (AccountStateEnum e : AccountStateEnum.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException(value);
    }

}