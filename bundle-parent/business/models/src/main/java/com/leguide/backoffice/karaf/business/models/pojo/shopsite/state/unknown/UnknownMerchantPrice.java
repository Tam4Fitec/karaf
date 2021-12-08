package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.unknown;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.MerchantPrice;

public class UnknownMerchantPrice implements MerchantPrice {

	private Integer id;
	private String libelle;

	public UnknownMerchantPrice(Integer id) {
		this.id = id;
		this.libelle = "Unknown";
	}
	public UnknownMerchantPrice(Integer id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getLibelle() {
		return libelle;
	}

}
