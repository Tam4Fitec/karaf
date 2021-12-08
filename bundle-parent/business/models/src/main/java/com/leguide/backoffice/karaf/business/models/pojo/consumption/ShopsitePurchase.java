package com.leguide.backoffice.karaf.business.models.pojo.consumption;

/**
 * ShopsitePurchase model
 */
public class ShopsitePurchase {

    private Double consumption;

    private Long nbClicks;

    private Double avgCpc;

    private Double maximumAmount;

    public Double getConsumption() {
        return consumption;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public Long getNbClicks() {
        return nbClicks;
    }

    public void setNbClicks(Long nbClicks) {
        this.nbClicks = nbClicks;
    }

    public Double getAvgCpc() {
        return avgCpc;
    }

    public void setAvgCpc(Double avgCpc) {
        this.avgCpc = avgCpc;
    }

    public Double getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Double maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    @Override
    public String toString() {
        return "ShopsitePurchase{" +
                "consumption=" + consumption +
                ", nbClicks=" + nbClicks +
                ", avgCpc=" + avgCpc +
                ", maximumAmount=" + maximumAmount +
                '}';
    }
}
