package com.leguide.backoffice.karaf.bundle.services.search.engine.model;

import java.io.Serializable;
import java.util.Date;

public class PriceAlert implements Serializable {


    private static final long serialVersionUID = -7578049600217435828L;
    private long id;

    private String reference;

    private Boolean isProduct;

    private Float maxPrice;

    private Date activatedOn;

    private Date expiresOn;

    public PriceAlert() {
    }

    public PriceAlert(long id, String reference, Boolean isProduct, Float maxPrice, Date activatedOn, Date expiresOn) {
        this.id = id;
        this.reference = reference;
        this.isProduct = isProduct;
        this.maxPrice = maxPrice;
        this.activatedOn = activatedOn;
        this.expiresOn = expiresOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Boolean getIsProduct() {
        return isProduct;
    }

    public void setIsProduct(Boolean isProduct) {
        this.isProduct = isProduct;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Date getActivatedOn() {
        return activatedOn;
    }

    public void setActivatedOn(Date activatedOn) {
        this.activatedOn = activatedOn;
    }

    public Date getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(Date expiresOn) {
        this.expiresOn = expiresOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceAlert that = (PriceAlert) o;

        if (id != that.id) return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        if (isProduct != null ? !isProduct.equals(that.isProduct) : that.isProduct != null) return false;
        if (maxPrice != null ? !maxPrice.equals(that.maxPrice) : that.maxPrice != null) return false;
        if (expiresOn != null ? !expiresOn.equals(that.expiresOn) : that.expiresOn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (isProduct != null ? isProduct.hashCode() : 0);
        result = 31 * result + (maxPrice != null ? maxPrice.hashCode() : 0);
        result = 31 * result + (expiresOn != null ? expiresOn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PriceAlert{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", isProduct=" + isProduct +
                ", maxPrice=" + maxPrice +
                ", expiresOn=" + expiresOn +
                '}';
    }
}
