package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums;

import java.io.Serializable;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.StateReason;

public enum StateReasonEnum implements StateReason, Serializable {
	TECHNICAL_SUSPENSION("Technical suspension"), 
	BAD_PAYER("Bad payer"), 
	APPROVED_FREE("Approved free"),
	STOPPED("Stopped"),
	CONTRACT_SUSPENSION("Contract suspension"),
	TECH_SUSP_M2M("Technical suspension until 2 months");

	private String libelle;
	private StateReasonEnum(String libelle) {
		this.libelle = libelle;
	}

	public String getId() {
		return name();
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public static StateReasonEnum getReasonByLabel(String label) {
		StateReasonEnum[] values = values();
		for (StateReasonEnum reason : values) {
			if(reason.getLibelle().equals(label))
				return reason;
		}
		throw new IllegalArgumentException("The label'"+label+"' for reason is unknown");
	}
}
