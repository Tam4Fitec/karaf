package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums;

import java.io.Serializable;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.MerchantSort;

public enum MerchantSortEnum implements MerchantSort, Serializable {
	PRIORITY_PLUS(50, "Priority +"),
	PRIORITY_MINUS(40, "Priority -"),
	AFFILIATED_PLUS(20, "Affiliated +"),
	FREE(3, "Free"),
	MINIMUM(0, "Minimum");
	
	private int id;
	private String libelle;
	private MerchantSortEnum(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public static MerchantSortEnum getMerchantSortById(int id) {
		MerchantSortEnum[] values = values();
		for (MerchantSortEnum clicType : values) {
			if(clicType.getId() == id)
				return clicType;
		}
		throw new IllegalArgumentException("The id '"+id+"' for merchant sort is unknown");
	}
}
