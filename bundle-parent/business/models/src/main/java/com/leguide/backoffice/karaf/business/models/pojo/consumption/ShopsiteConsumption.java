package com.leguide.backoffice.karaf.business.models.pojo.consumption;

import java.util.Date;

/**
 * ShopsiteConsumption model
 */
public class ShopsiteConsumption {

    private String contractCode;

    private Long storeUid;

    private Double currentAmount;

    private Double maximumAmount;

    private Date startDate;

    private String amountAlert;

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Long getStoreUid() {
        return storeUid;
    }

    public void setStoreUid(Long storeUid) {
        this.storeUid = storeUid;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Double getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Double maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getAmountAlert() {
        return amountAlert;
    }

    public void setAmountAlert(String amountAlert) {
        this.amountAlert = amountAlert;
    }
}
