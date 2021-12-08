package com.leguide.backoffice.karaf.business.models.pojo.contact.enums;

import com.leguide.backoffice.karaf.business.models.pojo.contact.ContactFunction;

public enum ContactFunctionEnum implements ContactFunction {
	COO_CEO(1, "COO / CEO"),
	SALES(2, "Sales"),
	MARKETING_ADVERTISING(3, "Marketing / Advertising"),
	IT_WEBMASTER_GRAPHIC_DESIGNER(4, "IT / Webmaster / Graphic Designer"),
	PRODUCT_MANAGER_PROJECT_MANAGER(5, "Product Manager / Project Manager"),
	FINANCE_ACCOUNTING(6, "Finance / Accounting"),
	AGENCY(7, "Agency"),
	CONSULTANT_FREELANCE(8, "Consultant / Freelance"),
	OTHER(9, "Other");

	private int id;
	private String libelle;
	
	private ContactFunctionEnum(int id, String libelle) {
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

	public static ContactFunctionEnum getFunctionById(int id) {
		for(ContactFunctionEnum function : values()) {
			if(function.getId() == id)
				return function;
		}
		return null;
	}
	
	public static ContactFunctionEnum retrieveFunctionByLibelle(String libelle) {
		for(ContactFunctionEnum function : values()) {
			if(function.getLibelle().equals(libelle))
				return function;
		}
		return null;
	}

}
