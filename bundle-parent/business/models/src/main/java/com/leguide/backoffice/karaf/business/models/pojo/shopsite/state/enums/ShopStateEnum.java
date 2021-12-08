package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums;

import java.io.Serializable;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ShopState;


public enum ShopStateEnum implements ShopState, Serializable {
	CLIENT(30, "Client"), 
	AFFILIATE(25, "Affiliate"), 
	FREE_PLUS(15, "Free plus"), 
	FREE(10, "Free"),
	NEW(8, "New"),
	STANDBY(5, "On standby"), 
	
	NEW_WITH_CATALOG(-6, "New with catalog"),
	ENTERED_ADMINISTRATION(-9, "Entered administration"),
	BLACKLISTED(-10, "Blacklisted"),
	SEXSHOP(-11, "Sexshop"),
	NEW_POTENTIAL_CLIENT(-20, "New potential client"),
	TO_BE_DELETED(-21, "To be deleted"),
	INCOMPLETE(0, "Incomplete"),
	
	// To delete when dooyoo disappear
	DOOYOO_ONLY(1, "Dooyoo only"),
	DOOYOO_PLUS(13, "Dooyoo plus");
	
	
	private int id;
	private String libelle;

	private ShopStateEnum(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public static ShopStateEnum getShopStateById(int id) {
		ShopStateEnum[] values = values();
		for (ShopStateEnum state : values) {
			if(state.getId() == id)
				return state;
		}
		throw new IllegalArgumentException("The id '"+id+"' shop state is unknown");
	}
	
	public static ShopStateEnum getDefault() {
		return ShopStateEnum.NEW_POTENTIAL_CLIENT;
	}
}
