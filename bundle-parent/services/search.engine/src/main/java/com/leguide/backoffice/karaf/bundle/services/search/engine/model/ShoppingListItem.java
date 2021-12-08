package com.leguide.backoffice.karaf.bundle.services.search.engine.model;

import java.io.Serializable;


public class ShoppingListItem implements Serializable {


    /**
	 * Serial Id
	 */
	private static final long serialVersionUID = 8691391114160382033L;

	private long uniqueID;
    private String reference;
    private Boolean isProduct;
    private Boolean isAvailable;
    private long shoppingListId;
    private String shoppingListName;

    public long getUniqueID() {
        return uniqueID;
    }
    public void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
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
    public Boolean getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isAvailable == null) ? 0 : isAvailable.hashCode());
        result = prime * result + ((isProduct == null) ? 0 : isProduct.hashCode());
        result = prime * result + ((reference == null) ? 0 : reference.hashCode());
        result = prime * result + (int) (shoppingListId ^ (shoppingListId >>> 32));
        result = prime * result + ((shoppingListName == null) ? 0 : shoppingListName.hashCode());
        result = prime * result + (int) (uniqueID ^ (uniqueID >>> 32));
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
        ShoppingListItem other = (ShoppingListItem) obj;
        if (isAvailable == null) {
            if (other.isAvailable != null)
                return false;
        } else if (!isAvailable.equals(other.isAvailable))
            return false;
        if (isProduct == null) {
            if (other.isProduct != null)
                return false;
        } else if (!isProduct.equals(other.isProduct))
            return false;
        if (reference == null) {
            if (other.reference != null)
                return false;
        } else if (!reference.equals(other.reference))
            return false;
        if (shoppingListId != other.shoppingListId)
            return false;
        if (shoppingListName == null) {
            if (other.shoppingListName != null)
                return false;
        } else if (!shoppingListName.equals(other.shoppingListName))
            return false;
        if (uniqueID != other.uniqueID)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "ShoppingListItem [uniqueID=" + uniqueID + ", reference=" + reference + ", isProduct=" + isProduct
                + ", isAvailable=" + isAvailable + ", shoppingListId=" + shoppingListId + ", shoppingListName="
                + shoppingListName + "]";
    }

}