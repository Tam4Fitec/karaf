package com.leguide.backoffice.karaf.webservices.wsclient.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Consumption
 */
@XmlRootElement
public class Consumption {

    private String month;

    private Double currentAmount;

    private Double maximumAmount;

    public Consumption() {
    }

    public Consumption(String month, Double currentAmount, Double maximumAmount) {
        this.month = month;
        this.currentAmount = currentAmount;
        this.maximumAmount = maximumAmount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Double maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }
}
