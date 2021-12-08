package com.leguide.backoffice.karaf.business.models.notification.merchant.state;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ShopSiteState;

public class MerchantStateUpdated {
	private Long shopsiteId;
	private String shopName;
    private String country;
    private Integer countryInternalCode;
    private Integer languageId;;
	private String language;;
	private ShopSiteState oldState;
	private ShopSiteState newState;

	public MerchantStateUpdated() {}

    public MerchantStateUpdated(Long shopsiteId, ShopSiteState oldState, ShopSiteState newState) {
        this.shopsiteId = shopsiteId;
        this.oldState = oldState;
        this.newState = newState;
    }

	public MerchantStateUpdated(Long shopsiteId, String country, ShopSiteState oldState, ShopSiteState newState) {
		this.shopsiteId = shopsiteId;
        this.country = country;
		this.oldState = oldState;
		this.newState = newState;
	}

	public Long getShopsiteId() {
		return shopsiteId;
	}

	public void setShopsiteId(Long shopsiteId) {
		this.shopsiteId = shopsiteId;
	}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ShopSiteState getOldState() {
		return oldState;
	}

	public void setOldState(ShopSiteState oldState) {
		this.oldState = oldState;
	}

	public ShopSiteState getNewState() {
		return newState;
	}

	public void setNewState(ShopSiteState newState) {
		this.newState = newState;
	}

    public Integer getCountryInternalCode() {
        return countryInternalCode;
    }

    public void setCountryInternalCode(Integer countryInternalCode) {
        this.countryInternalCode = countryInternalCode;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
