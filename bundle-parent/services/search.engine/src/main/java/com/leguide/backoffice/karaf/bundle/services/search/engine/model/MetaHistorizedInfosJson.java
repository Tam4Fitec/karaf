package com.leguide.backoffice.karaf.bundle.services.search.engine.model;

import java.io.Serializable;


public class MetaHistorizedInfosJson implements Serializable{

	
	private static final long serialVersionUID = 427753029903731594L;

	
	
	private String offerName;
	
	private String offerDescription;
	
	private String shopSiteName;

	
	
	public MetaHistorizedInfosJson() {
		super();
	}

	public MetaHistorizedInfosJson(String offerName, String offerDescription,String shopSiteName) {
		super();
		this.offerName = offerName;
		this.offerDescription = offerDescription;
		this.shopSiteName = shopSiteName;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferDescription() {
		return offerDescription;
	}

	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	public String getShopSiteName() {
		return shopSiteName;
	}

	public void setShopSiteName(String shopSiteName) {
		this.shopSiteName = shopSiteName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((offerDescription == null) ? 0 : offerDescription.hashCode());
		result = prime * result
				+ ((offerName == null) ? 0 : offerName.hashCode());
		result = prime * result
				+ ((shopSiteName == null) ? 0 : shopSiteName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetaHistorizedInfosJson other = (MetaHistorizedInfosJson) obj;
		if (offerDescription == null) {
			if (other.offerDescription != null)
				return false;
		} else if (!offerDescription.equals(other.offerDescription))
			return false;
		if (offerName == null) {
			if (other.offerName != null)
				return false;
		} else if (!offerName.equals(other.offerName))
			return false;
		if (shopSiteName == null) {
			if (other.shopSiteName != null)
				return false;
		} else if (!shopSiteName.equals(other.shopSiteName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MetaHistorizedInfosJson [offerName=" + offerName
				+ ", offerDescription=" + offerDescription + ", shopSiteName="
				+ shopSiteName + "]";
	}
}
