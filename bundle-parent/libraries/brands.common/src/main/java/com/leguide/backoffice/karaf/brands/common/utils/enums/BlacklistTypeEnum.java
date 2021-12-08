package com.leguide.backoffice.karaf.brands.common.utils.enums;


public enum BlacklistTypeEnum {
	SEO("seo"),
	SEM("sem"),
	ALL("all");
	
	private String value; 
	
	private BlacklistTypeEnum(String status) {
		this.value = status;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	 public static BlacklistTypeEnum fromValue(String v) {
        for (BlacklistTypeEnum c: BlacklistTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }	
}
