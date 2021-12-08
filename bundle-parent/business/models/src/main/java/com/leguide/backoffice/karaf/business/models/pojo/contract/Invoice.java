package com.leguide.backoffice.karaf.business.models.pojo.contract;

import java.util.Date;

public class Invoice {

    private Long number;

    private Date issueDate;

    private Date deadline;

    private Double amountWithTax;

    private Double amountNet;

    private Double cpcNet;

    private String paymentStatus;
    
    private String clientId;

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Double getAmountWithTax() {
        return amountWithTax;
    }

    public void setAmountWithTax(Double amountWithTax) {
        this.amountWithTax = amountWithTax;
    }

    public Double getAmountNet() {
        return amountNet;
    }

    public void setAmountNet(Double amountNet) {
        this.amountNet = amountNet;
    }

    public Double getCpcNet() {
        return cpcNet;
    }

    public void setCpcNet(Double cpcNet) {
        this.cpcNet = cpcNet;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    public String getClientId() {
		return clientId;
	}
    
    public void setClientId(String clientId) {
		this.clientId = clientId;
	}
}
