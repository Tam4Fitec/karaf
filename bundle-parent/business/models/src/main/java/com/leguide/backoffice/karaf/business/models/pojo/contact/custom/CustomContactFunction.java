package com.leguide.backoffice.karaf.business.models.pojo.contact.custom;

import com.leguide.backoffice.karaf.business.models.pojo.contact.ContactFunction;

public class CustomContactFunction implements ContactFunction {

	private int id;
	private String libelle;
	
	public CustomContactFunction(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public CustomContactFunction(String libelle) {
		this.id = 0;
		this.libelle = libelle;
	}

	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public String getLibelle() {
		return libelle;
	}
}
