package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums;

import java.io.Serializable;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.MerchantPrice;

public enum MerchantPriceEnum implements MerchantPrice, Serializable {
	CATEGORY(16, "Price A 0,20 - 0,14"), 
	CPO(13, "CPO"), 
	INDIFFERENT(101, "Indifferent"),
	UNSPECIFIED(102, "Unspecified"),
	CPC(43,"CPC")
	;
	
	private int id;
	private String libelle;
	private MerchantPriceEnum(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public static MerchantPriceEnum getMerchantPriceById(int id) {
		MerchantPriceEnum[] values = values();
		for (MerchantPriceEnum clicType : values) {
			if(clicType.getId() == id)
				return clicType;
		}
		throw new IllegalArgumentException("The id '"+id+"' for merchant price is unknown");
	}
}
