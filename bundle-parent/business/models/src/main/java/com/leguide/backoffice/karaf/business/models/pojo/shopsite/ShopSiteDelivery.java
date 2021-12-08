package com.leguide.backoffice.karaf.business.models.pojo.shopsite;

import java.util.List;

public class ShopSiteDelivery {

    private List<Integer> deliveryModes;

    private String freeShippingCosts;

    private Integer shippingCostsFreeOver;

    private Long coolingOffPeriod;

    private String deliveryExpress;

    private String multipleAddress;

    private String multiplePerson;

    private String orderTracking;

    private String additionalRemarks;

    public List<Integer> getDeliveryModes() {
        return deliveryModes;
    }

    public void setDeliveryModes(List<Integer> deliveryModes) {
        this.deliveryModes = deliveryModes;
    }

    public String getFreeShippingCosts() {
        return freeShippingCosts;
    }

    public void setFreeShippingCosts(String freeShippingCosts) {
        this.freeShippingCosts = freeShippingCosts;
    }

    public Integer getShippingCostsFreeOver() {
        return shippingCostsFreeOver;
    }

    public void setShippingCostsFreeOver(Integer shippingCostsFreeOver) {
        this.shippingCostsFreeOver = shippingCostsFreeOver;
    }

    public Long getCoolingOffPeriod() {
        return coolingOffPeriod;
    }

    public void setCoolingOffPeriod(Long coolingOffPeriod) {
        this.coolingOffPeriod = coolingOffPeriod;
    }

    public String getDeliveryExpress() {
        return deliveryExpress;
    }

    public void setDeliveryExpress(String deliveryExpress) {
        this.deliveryExpress = deliveryExpress;
    }

    public String getMultipleAddress() {
        return multipleAddress;
    }

    public void setMultipleAddress(String multipleAddress) {
        this.multipleAddress = multipleAddress;
    }

    public String getMultiplePerson() {
        return multiplePerson;
    }

    public void setMultiplePerson(String multiplePerson) {
        this.multiplePerson = multiplePerson;
    }

    public String getOrderTracking() {
        return orderTracking;
    }

    public void setOrderTracking(String orderTracking) {
        this.orderTracking = orderTracking;
    }

    public String getAdditionalRemarks() {
        return additionalRemarks;
    }

    public void setAdditionalRemarks(String additionalRemarks) {
        this.additionalRemarks = additionalRemarks;
    }
}
