package com.leguide.backoffice.karaf.bundle.services.search.engine.model;

import java.io.Serializable;

/**
 * Pojo containing all relevant information to display a product-offer on
 * price alert emails
 */
public class PriceAlertProductOfferDisplay implements Serializable {

    private static final long serialVersionUID = -8794908652983728394L;

    private Long id;
    private Integer shopSiteId;
    private String shopName;
    private String imageUrl;
    private String goUrl;
    private String designation;
    private Double price;
    private String formattedPrice;

    private String alertDate;
    private Float alertPrice;
    private String formattedAlertPrice;

    public PriceAlertProductOfferDisplay() {
        super();
    }

    public PriceAlertProductOfferDisplay(Long id, Integer shopSiteId, String shopName, String imageUrl, String designation,
                                         Double price, String goUrl, String alertDate, Float alertPrice) {
        super();
        this.id = id;
        this.shopSiteId = shopSiteId;
        this.shopName = shopName;
        this.imageUrl = imageUrl;
        this.designation = designation;
        this.goUrl = goUrl;
        this.price = price;
        this.alertDate = alertDate;
        this.alertPrice = alertPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getShopSiteId() {
        return shopSiteId;
    }

    public void setShopSiteId(Integer shopSiteId) {
        this.shopSiteId = shopSiteId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getGoUrl() {
        return goUrl;
    }

    public void setGoUrl(String goUrl) {
        this.goUrl = goUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(String alertDate) {
        this.alertDate = alertDate;
    }

    public Float getAlertPrice() {
        return alertPrice;
    }

    public void setAlertPrice(Float alertPrice) {
        this.alertPrice = alertPrice;
    }

    public String getFormattedPrice() {
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    public String getFormattedAlertPrice() {
        return formattedAlertPrice;
    }

    public void setFormattedAlertPrice(String formattedAlertPrice) {
        this.formattedAlertPrice = formattedAlertPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceAlertProductOfferDisplay that = (PriceAlertProductOfferDisplay) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (shopSiteId != null ? !shopSiteId.equals(that.shopSiteId) : that.shopSiteId != null) return false;
        if (shopName != null ? !shopName.equals(that.shopName) : that.shopName != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (goUrl != null ? !goUrl.equals(that.goUrl) : that.goUrl != null) return false;
        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (formattedPrice != null ? !formattedPrice.equals(that.formattedPrice) : that.formattedPrice != null)
            return false;
        if (alertDate != null ? !alertDate.equals(that.alertDate) : that.alertDate != null) return false;
        if (formattedAlertPrice != null ? !formattedAlertPrice.equals(that.formattedAlertPrice) : that.formattedAlertPrice != null)
            return false;
        if (alertPrice != null ? !alertPrice.equals(that.alertPrice) : that.alertPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (shopSiteId != null ? shopSiteId.hashCode() : 0);
        result = 31 * result + (shopName != null ? shopName.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (goUrl != null ? goUrl.hashCode() : 0);
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (formattedPrice != null ? formattedPrice.hashCode() : 0);
        result = 31 * result + (alertDate != null ? alertDate.hashCode() : 0);
        result = 31 * result + (formattedAlertPrice != null ? formattedAlertPrice.hashCode() : 0);
        result = 31 * result + (alertPrice != null ? alertPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PriceAlertProductOfferDisplay{" +
                "id=" + id +
                ", shopSiteId=" + shopSiteId +
                ", shopName='" + shopName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", goUrl='" + goUrl + '\'' +
                ", designation='" + designation + '\'' +
                ", price=" + price +
                ", formattedPrice='" + formattedPrice + '\'' +
                ", alertDate='" + alertDate + '\'' +
                ", formattedAlertPrice='" + formattedAlertPrice + '\'' +
                ", alertPrice=" + alertPrice +
                '}';
    }
}
