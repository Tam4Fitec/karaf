package com.leguide.backoffice.karaf.business.models.pojo.click.deduplication.ipblacklist;

public class BlackIPOnShopsite {
	private String ip;
	private Long storeId;
	private String country;
	
	public BlackIPOnShopsite(String ip, Long storeId, String country) {
		this.ip = ip;
		this.storeId = storeId;
		this.country = country;
	}

	public String getIp() {
		return ip;
	}

	public Long getStoreId() {
		return storeId;
	}
	
	public String getCountry() {
		return country;
	}
	
	public boolean matches(String ip, Long storeId, String country) {
		return this.ip.equals(ip) && this.storeId.equals(storeId) && this.country.equals(country);
	}
}
