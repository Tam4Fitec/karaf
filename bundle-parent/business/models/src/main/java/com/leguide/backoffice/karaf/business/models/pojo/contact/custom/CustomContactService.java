package com.leguide.backoffice.karaf.business.models.pojo.contact.custom;

import com.leguide.backoffice.karaf.business.models.pojo.contact.ContactService;

public class CustomContactService implements ContactService {

	private int id;
	private String libelle;
	
	public CustomContactService(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public CustomContactService(String libelle) {
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
