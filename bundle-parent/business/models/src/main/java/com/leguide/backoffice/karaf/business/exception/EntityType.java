package com.leguide.backoffice.karaf.business.exception;

public enum EntityType {
    ACCOUNT("account"), CONTACT("contact"), SHOPSITE("shopsite"), REFERENCE_ROLE("referenceRole");

    private String name;

    EntityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
