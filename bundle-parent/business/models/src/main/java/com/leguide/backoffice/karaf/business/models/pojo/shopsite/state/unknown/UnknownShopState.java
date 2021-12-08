package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.unknown;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ShopState;

public class UnknownShopState implements ShopState {

	private Integer id;
	private String libelle;

	public UnknownShopState(Integer id) {
		this.id = id;
		this.libelle = "Unknown";
	}
	public UnknownShopState(Integer id, String libelle) {
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
