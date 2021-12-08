package com.leguide.backoffice.karaf.business.models.pojo.contact.enums;

import com.leguide.backoffice.karaf.business.models.pojo.contact.ContactService;

public enum ContactServiceEnum implements ContactService {
	GENERAL_MANAGEMENT(1, "General Management"), 
	SALES_MANAGEMENT(2, "Sales Management"), 
	MARKETING_ADVERTISING_MANAGEMENT(3, "Marketing / Advertising Management"),
	ADMINISTRATIVE_AND_FINANCE_MANAGEMENT(4, "Administrative and Finance Management"),
	IT_MANAGEMENT(5, "IT Management"),
	OTHER(6, "Other");

	private int id;
	private String libelle;
	
	private ContactServiceEnum(int id, String libelle) {
		this.id = id;
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
	
	public static ContactServiceEnum getServiceById(int id) {
		for(ContactServiceEnum service : values()) {
			if(service.getId() == id)
				return service;
		}
		return null;
	}

	public static ContactServiceEnum retrieveServiceByLibelle(String libelle) {
		for(ContactServiceEnum service : values()) {
			if(service.getLibelle().equals(libelle))
				return service;
		}
		return null;
	}

}
