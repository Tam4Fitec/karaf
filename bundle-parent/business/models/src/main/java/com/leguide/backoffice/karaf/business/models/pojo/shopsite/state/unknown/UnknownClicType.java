package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.unknown;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ClicType;

public class UnknownClicType implements ClicType {

	private char id;
	private String libelle;

	public UnknownClicType(char id) {
		this.id = id;
		this.libelle = "Unknown";
	}
	public UnknownClicType(char id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	@Override
	public char getId() {
		return id;
	}

	@Override
	public String getLibelle() {
		return libelle;
	}

}
