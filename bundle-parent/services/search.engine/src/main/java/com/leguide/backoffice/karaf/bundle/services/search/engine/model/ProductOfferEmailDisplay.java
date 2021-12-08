package com.leguide.backoffice.karaf.bundle.services.search.engine.model;

import java.io.Serializable;

/**
 * Pojo containing all relevant information to display a product-offer on
 * shoppinglist emails
 * 
 * @author thomas
 *
 */
public class ProductOfferEmailDisplay implements Serializable {

    private static final long serialVersionUID = -8794908652983728394L;

    private Integer shopSiteId;
    private String shopName;
    private String imageUrl;
    private String goUrl;
    private String designation;
    private String price1;
    private String price1BeforeDiscount;
    private Integer price1DiscountPerc; //as in 25 , not 0.25 
    private long shoppingListId;
    private String shoppingListName;
    private boolean isFromProduct = false;
    //product id or offer id, depending on isFromProduct
    private String reference;
    //flag from the search engine,  1/0 if product is on sales or not
    private boolean onSales = false;
    

    public ProductOfferEmailDisplay() {
        super();
    }

    public ProductOfferEmailDisplay(Integer shopSiteId, String shopName, String imageUrl, String designation,
            String price, String goUrl) {
        super();
        this.shopSiteId = shopSiteId;
        this.shopName = shopName;
        this.imageUrl = imageUrl;
        this.designation = designation;
        this.price1 = price;
        this.goUrl = goUrl;
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

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public long getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(long shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getShoppingListName() {
        return shoppingListName;
    }

    public void setShoppingListName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }

    public boolean isFromProduct() {
        return isFromProduct;
    }

    public void setFromProduct(boolean isProduct) {
        this.isFromProduct = isProduct;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPrice1BeforeDiscount() {
        return price1BeforeDiscount;
    }

    public void setPrice1BeforeDiscount(String price1BeforeDiscount) {
        this.price1BeforeDiscount = price1BeforeDiscount;
    }

    public Integer getPrice1DiscountPerc() {
        return price1DiscountPerc;
    }

    public void setPrice1DiscountPerc(Integer price1DiscountPerc) {
        this.price1DiscountPerc = price1DiscountPerc;
    }

    public boolean isOnSales() {
        return onSales;
    }

    public void setOnSales(boolean isOnSales) {
        this.onSales = isOnSales;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((designation == null) ? 0 : designation.hashCode());
        result = prime * result + ((goUrl == null) ? 0 : goUrl.hashCode());
        result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
        result = prime * result + (isFromProduct ? 1231 : 1237);
        result = prime * result + (onSales ? 1231 : 1237);
        result = prime * result + ((price1 == null) ? 0 : price1.hashCode());
        result = prime * result + ((price1BeforeDiscount == null) ? 0 : price1BeforeDiscount.hashCode());
        result = prime * result + ((price1DiscountPerc == null) ? 0 : price1DiscountPerc.hashCode());
        result = prime * result + ((reference == null) ? 0 : reference.hashCode());
        result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
        result = prime * result + ((shopSiteId == null) ? 0 : shopSiteId.hashCode());
        result = prime * result + (int) (shoppingListId ^ (shoppingListId >>> 32));
        result = prime * result + ((shoppingListName == null) ? 0 : shoppingListName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductOfferEmailDisplay other = (ProductOfferEmailDisplay) obj;
        if (designation == null) {
            if (other.designation != null)
                return false;
        } else if (!designation.equals(other.designation))
            return false;
        if (goUrl == null) {
            if (other.goUrl != null)
                return false;
        } else if (!goUrl.equals(other.goUrl))
            return false;
        if (imageUrl == null) {
            if (other.imageUrl != null)
                return false;
        } else if (!imageUrl.equals(other.imageUrl))
            return false;
        if (isFromProduct != other.isFromProduct)
            return false;
        if (onSales != other.onSales)
            return false;
        if (price1 == null) {
            if (other.price1 != null)
                return false;
        } else if (!price1.equals(other.price1))
            return false;
        if (price1BeforeDiscount == null) {
            if (other.price1BeforeDiscount != null)
                return false;
        } else if (!price1BeforeDiscount.equals(other.price1BeforeDiscount))
            return false;
        if (price1DiscountPerc == null) {
            if (other.price1DiscountPerc != null)
                return false;
        } else if (!price1DiscountPerc.equals(other.price1DiscountPerc))
            return false;
        if (reference == null) {
            if (other.reference != null)
                return false;
        } else if (!reference.equals(other.reference))
            return false;
        if (shopName == null) {
            if (other.shopName != null)
                return false;
        } else if (!shopName.equals(other.shopName))
            return false;
        if (shopSiteId == null) {
            if (other.shopSiteId != null)
                return false;
        } else if (!shopSiteId.equals(other.shopSiteId))
            return false;
        if (shoppingListId != other.shoppingListId)
            return false;
        if (shoppingListName == null) {
            if (other.shoppingListName != null)
                return false;
        } else if (!shoppingListName.equals(other.shoppingListName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProductOfferEmailDisplay [shopSiteId=" + shopSiteId + ", shopName=" + shopName + ", imageUrl="
                + imageUrl + ", goUrl=" + goUrl + ", designation=" + designation + ", price1=" + price1
                + ", price1BeforeDiscount=" + price1BeforeDiscount + ", price1DiscountPerc=" + price1DiscountPerc
                + ", shoppingListId=" + shoppingListId + ", shoppingListName=" + shoppingListName + ", isFromProduct="
                + isFromProduct + ", reference=" + reference + ", onSales=" + onSales + "]";
    }

}
