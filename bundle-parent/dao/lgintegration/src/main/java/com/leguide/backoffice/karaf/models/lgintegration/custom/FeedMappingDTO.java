package com.leguide.backoffice.karaf.models.lgintegration.custom;

import java.io.Serializable;

public class FeedMappingDTO implements Serializable {

	private static final long serialVersionUID = 4287665472871506339L;
	
	private String libelle;
	private Integer value;
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
}
