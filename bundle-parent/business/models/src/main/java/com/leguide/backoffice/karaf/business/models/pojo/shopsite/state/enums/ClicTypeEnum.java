package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums;

import java.io.Serializable;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ClicType;

public enum ClicTypeEnum implements ClicType, Serializable {
	PAID('p', "Paid"), CAPPED('c', "Capped"), FREE('g', "Free");
	
	private char id;
	private String libelle;
	private ClicTypeEnum(char id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public char getId() {
		return id;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public static ClicTypeEnum getClicTypeById(char id) {
		ClicTypeEnum[] values = values();
		for (ClicTypeEnum clicType : values) {
			if(clicType.getId() == id)
				return clicType;
		}
		throw new IllegalArgumentException("The id '"+id+"' for clic type is unknown");
	}
}
