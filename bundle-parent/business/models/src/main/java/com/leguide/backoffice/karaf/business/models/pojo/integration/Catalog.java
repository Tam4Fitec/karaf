package com.leguide.backoffice.karaf.business.models.pojo.integration;

public class Catalog {

    private Long catalogId;

    private Boolean active;

    private Long shopsiteId;

    private Long offersCount;
    
    private Long onlineCount;

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getShopsiteId() {
        return shopsiteId;
    }

    public void setShopsiteId(Long shopsiteId) {
        this.shopsiteId = shopsiteId;
    }

    public Long getOffersCount() {
        return offersCount;
    }

    public void setOffersCount(Long offersCount) {
        this.offersCount = offersCount;
    }

	public Long getOnlineCount() {
		return onlineCount;
	}

	public void setOnlineCount(Long onlineCount) {
		this.onlineCount = onlineCount;
	}

	@Override
	public String toString() {
		return "Catalog [catalogId=" + catalogId + ", active=" + active
				+ ", shopsiteId=" + shopsiteId + ", offersCount=" + offersCount
				+ ", onlineCount=" + onlineCount + "]";
	}
    
  
}
