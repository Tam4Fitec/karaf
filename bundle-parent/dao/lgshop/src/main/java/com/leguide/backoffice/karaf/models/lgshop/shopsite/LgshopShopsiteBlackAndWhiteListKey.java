package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LgshopShopsiteBlackAndWhiteListKey implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6076911622804769551L;

    @Column(name = "rf_ksite_id")
    private Integer refKsiteId;

    @Column(name = "id_shopsite")
    private Long shopsiteId;

    public LgshopShopsiteBlackAndWhiteListKey() {
    }

    public LgshopShopsiteBlackAndWhiteListKey(Integer refKsiteId, Long shopsiteId) {
        super();
        this.refKsiteId = refKsiteId;
        this.shopsiteId = shopsiteId;
    }

    public Integer getRefKsiteId() {
        return refKsiteId;
    }

    public void setRefKsiteId(Integer refKsiteId) {
        this.refKsiteId = refKsiteId;
    }

    public Long getShopsiteId() {
        return shopsiteId;
    }

    public void setShopsiteId(Long shopsiteId) {
        this.shopsiteId = shopsiteId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((refKsiteId == null) ? 0 : refKsiteId.hashCode());
        result = prime * result + ((shopsiteId == null) ? 0 : shopsiteId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LgshopShopsiteBlackAndWhiteListKey other = (LgshopShopsiteBlackAndWhiteListKey) obj;
        if (refKsiteId == null) {
            if (other.refKsiteId != null) {
                return false;
            }
        } else if (!refKsiteId.equals(other.refKsiteId)) {
            return false;
        }
        if (shopsiteId == null) {
            if (other.shopsiteId != null) {
                return false;
            }
        } else if (!shopsiteId.equals(other.shopsiteId)) {
            return false;
        }
        return true;
    }
}
