package com.leguide.backoffice.karaf.models.lgshop.referentiel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LgshopRefKSiteLabelKey implements Serializable {   

    private static final long serialVersionUID = 918519290319119185L;

    @Column(name="rf_ksite_id")  
    private Integer rfKSiteId;
    
    @Column(name="label", nullable=false)
    private String label;
    
    @Column(name="cty_internal_number", nullable=false)
    private Integer countryInternalNumber;

    public LgshopRefKSiteLabelKey() {}

    public LgshopRefKSiteLabelKey(Integer rfKSiteId, String label, Integer countryInternalNumber) {
        super();
        this.rfKSiteId = rfKSiteId;
        this.label = label;
        this.countryInternalNumber = countryInternalNumber;
    }

    public Integer getRfKSiteId() {
        return rfKSiteId;
    }

    public void setRfKSiteId(Integer rfKSiteId) {
        this.rfKSiteId = rfKSiteId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getCountryInternalNumber() {
        return countryInternalNumber;
    }

    public void setCountryInternalNumber(Integer countryInternalNumber) {
        this.countryInternalNumber = countryInternalNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((countryInternalNumber == null) ? 0 : countryInternalNumber.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + ((rfKSiteId == null) ? 0 : rfKSiteId.hashCode());
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
        LgshopRefKSiteLabelKey other = (LgshopRefKSiteLabelKey) obj;
        if (countryInternalNumber == null) {
            if (other.countryInternalNumber != null) {
                return false;
            }
        } else if (!countryInternalNumber.equals(other.countryInternalNumber)) {
            return false;
        }
        if (label == null) {
            if (other.label != null) {
                return false;
            }
        } else if (!label.equals(other.label)) {
            return false;
        }
        if (rfKSiteId == null) {
            if (other.rfKSiteId != null) {
                return false;
            }
        } else if (!rfKSiteId.equals(other.rfKSiteId)) {
            return false;
        }
        return true;
    }

    
}
