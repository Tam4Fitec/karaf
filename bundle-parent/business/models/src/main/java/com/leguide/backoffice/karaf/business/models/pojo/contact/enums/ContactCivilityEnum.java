package com.leguide.backoffice.karaf.business.models.pojo.contact.enums;

import com.leguide.backoffice.karaf.business.models.pojo.contact.ContactCivility;

public enum ContactCivilityEnum implements ContactCivility {
	MRS(1, "Mrs"), MISS(2, "Miss"), MR(3, "Mr");

	private int id;
	private String libelle;
	
	private ContactCivilityEnum(int id, String libelle) {
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
	
	public static ContactCivilityEnum getTitleById(int id) {
		for(ContactCivilityEnum title : values()) {
			if(title.getId() == id)
				return title;
		}
		return null;
	}

	public static ContactCivilityEnum retrieveTitleByLibelle(String libelle) {
		for(ContactCivilityEnum title : values()) {
			if(title.getLibelle().equals(libelle))
				return title;
		}
		return null;
	}

}
