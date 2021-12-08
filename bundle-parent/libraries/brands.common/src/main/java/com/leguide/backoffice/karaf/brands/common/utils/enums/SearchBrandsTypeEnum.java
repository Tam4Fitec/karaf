package com.leguide.backoffice.karaf.brands.common.utils.enums;

public enum SearchBrandsTypeEnum {
    EXACT("exact"), LARGE("large"), LARGE_SPLIT("large_split"), EXTRA_LARGE("extra_large"), EXTRA_LARGE_SPLIT(
            "extra_large_split"), EXACT_ALIAS("exact_alias"), LARGE_ALIAS("large_alias"), LARGE_ALIAS_SPLIT(
            "large_alias_split"), EXTRA_LARGE_ALIAS("extra_large_alias"), EXTRA_LARGE_ALIAS_SPLIT(
            "extra_large_alias_split"), EXACT_BRAND_OR_ALIAS("exact_brand_or_alias");

    private String value;

    private SearchBrandsTypeEnum(String status) {
        this.value = status;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static SearchBrandsTypeEnum fromValue(String v) {
        for (SearchBrandsTypeEnum c : SearchBrandsTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
