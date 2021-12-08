package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.unknown;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.MerchantSort;

public class UnknownMerchantSort implements MerchantSort {

	private Integer id;
	private String libelle;

	public UnknownMerchantSort(Integer id) {
		this.id = id;
		this.libelle = "Unknown";
	}
	public UnknownMerchantSort(Integer id, String libelle) {
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
