package com.leguide.backoffice.karaf.business.models.pojo.contact.custom;

import com.leguide.backoffice.karaf.business.models.pojo.contact.ContactCivility;

public class CustomContactCivility implements ContactCivility {

	private int id;
	private String libelle;
	
	public CustomContactCivility(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public CustomContactCivility(String libelle) {
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
