package com.leguide.backoffice.karaf.business.models.notification.client.payment;

import java.util.Date;

public class BatchRequestResponseMetaDataReceived {
	private Integer numSequence;
	private Date creationDate;
	private Integer processingResponseCode;
	private Date responseReceivedDate;
	private Date processReceiveBeginDate;
	private Date processReceiveEndDate;
	private String version;
	
	public Integer getNumSequence() {
		return numSequence;
	}
	public void setNumSequence(Integer numSequence) {
		this.numSequence = numSequence;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getProcessingResponseCode() {
		return processingResponseCode;
	}
	public void setProcessingResponseCode(Integer processingResponseCode) {
		this.processingResponseCode = processingResponseCode;
	}
	public Date getResponseReceivedDate() {
		return responseReceivedDate;
	}
	public void setResponseReceivedDate(Date responseReceivedDate) {
		this.responseReceivedDate = responseReceivedDate;
	}
	public Date getProcessReceiveBeginDate() {
		return processReceiveBeginDate;
	}
	public void setProcessReceiveBeginDate(Date processReceiveBeginDate) {
		this.processReceiveBeginDate = processReceiveBeginDate;
	}
	public Date getProcessReceiveEndDate() {
		return processReceiveEndDate;
	}
	public void setProcessReceiveEndDate(Date processReceiveEndDate) {
		this.processReceiveEndDate = processReceiveEndDate;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}
