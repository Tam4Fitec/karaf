package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.unknown;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ReferentialState;

public class UnknownReferentialState implements ReferentialState {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String libelle;

	public UnknownReferentialState(Long id) {
		this.id = id;
		this.libelle = "Unknown";
	}
	public UnknownReferentialState(Long id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getLibelle() {
		return libelle;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
