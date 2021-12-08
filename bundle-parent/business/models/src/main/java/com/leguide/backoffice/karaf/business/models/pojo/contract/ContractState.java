package com.leguide.backoffice.karaf.business.models.pojo.contract;

import java.util.Date;

public class ContractState {
	private boolean active;
	private Date activeEndDate;
	private boolean suspended;
	private Date activeEndSuspension;
	private String suspensionType;
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getActiveEndDate() {
		return activeEndDate;
	}
	public void setActiveEndDate(Date activeEndDate) {
		this.activeEndDate = activeEndDate;
	}
	public boolean isSuspended() {
		return suspended;
	}
	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	public Date getSuspensionEndDate() {
		return activeEndSuspension;
	}
	public void setSuspensionEndDate(Date activeEndSuspension) {
		this.activeEndSuspension = activeEndSuspension;
	}
	public String getSuspensionType() {
		return suspensionType;
	}
	public void setSuspensionType(String suspensionType) {
		this.suspensionType = suspensionType;
	}
}
