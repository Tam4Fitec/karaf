package com.leguide.backoffice.karaf.brands.common.business.model.enums;

public enum MappedTypeEnum {
    ALIAS("alias"), BRAND("brand");

    private String value;

    private MappedTypeEnum(String status) {
        this.value = status;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static MappedTypeEnum fromValue(String v) {
        for (MappedTypeEnum c : MappedTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
