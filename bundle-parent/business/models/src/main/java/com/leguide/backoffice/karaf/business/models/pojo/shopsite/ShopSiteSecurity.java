package com.leguide.backoffice.karaf.business.models.pojo.shopsite;

import java.util.List;

public class ShopSiteSecurity {

    private List<Integer> paymentSolutions;

    private List<Integer> paymentCards;

    private List<Integer> otherPaymentMethods;

    private List<Integer> qualityLabels;

    private List<Integer> securityProtocols;

    public List<Integer> getPaymentSolutions() {
        return paymentSolutions;
    }

    public void setPaymentSolutions(List<Integer> paymentSolutions) {
        this.paymentSolutions = paymentSolutions;
    }

    public List<Integer> getPaymentCards() {
        return paymentCards;
    }

    public void setPaymentCards(List<Integer> paymentCards) {
        this.paymentCards = paymentCards;
    }

    public List<Integer> getOtherPaymentMethods() {
        return otherPaymentMethods;
    }

    public void setOtherPaymentMethods(List<Integer> otherPaymentMethods) {
        this.otherPaymentMethods = otherPaymentMethods;
    }

    public List<Integer> getQualityLabels() {
        return qualityLabels;
    }

    public void setQualityLabels(List<Integer> qualityLabels) {
        this.qualityLabels = qualityLabels;
    }

    public List<Integer> getSecurityProtocols() {
        return securityProtocols;
    }

    public void setSecurityProtocols(List<Integer> securityProtocols) {
        this.securityProtocols = securityProtocols;
    }
}
