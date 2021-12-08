package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.unknown;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.StateReason;

public class UnknownStateReason implements StateReason {

	private String id;
	private String libelle;

	public UnknownStateReason(String id) {
		this.id = id;
		this.libelle = id;
	}
	public UnknownStateReason(String id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getLibelle() {
		return libelle;
	}

}
