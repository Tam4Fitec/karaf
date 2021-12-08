package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums;

public enum ZeusNotationEnum {
    STANDARD(1), SILVER(5), GOLD(10);

    private ZeusNotationEnum(Integer level) {
        this.level = level;
    }

    private Integer level;

    public Integer getLevel() {
        return level;
    }
}
