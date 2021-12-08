package com.leguide.backoffice.karaf.business.models.ciaointegration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

public class CiaoIntegrationMappingPOJO implements Serializable {

    private static final long serialVersionUID = 7638911415035691589L;

    private boolean isError = false;
    private boolean isBlacklisted = false;
    private ErrorReasons reason = null;
    private String country = null;
    private Long storeid = null; //store id is not unique, store_id + country
    private Long catId = null; // CAT ID
    private Long idShopSite = null;
    private Long idAction = null;
    private Integer isSolde = null; //result from placement mapping
    private Long trafficId;

    public boolean isError() {
        return isError;
    }

    public void setError(boolean isError) {
        this.isError = isError;
    }

    public ErrorReasons getReason() {
        return reason;
    }

    public void setReason(ErrorReasons reason) {
        this.reason = reason;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getStoreid() {
        return storeid;
    }

    public void setStoreid(Long storeid) {
        this.storeid = storeid;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public Long getIdShopSite() {
        return idShopSite;
    }

    public void setIdShopSite(Long idShopSite) {
        this.idShopSite = idShopSite;
    }

    public Long getIdAction() {
        return idAction;
    }

    public void setIdAction(Long idAction) {
        this.idAction = idAction;
    }

    public Integer getIsSolde() {
        return isSolde;
    }

    public void setIsSolde(Integer isSolde) {
        this.isSolde = isSolde;
    }

    public Long getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(Long trafficId) {
        this.trafficId = trafficId;
    }

    public boolean isBlacklisted() {
        return isBlacklisted;
    }

    public void setBlacklisted(boolean isBlacklisted) {
        this.isBlacklisted = isBlacklisted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CiaoIntegrationMappingPOJO that = (CiaoIntegrationMappingPOJO) o;

        if (isBlacklisted != that.isBlacklisted) return false;
        if (isError != that.isError) return false;
        if (catId != null ? !catId.equals(that.catId) : that.catId != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (idAction != null ? !idAction.equals(that.idAction) : that.idAction != null) return false;
        if (idShopSite != null ? !idShopSite.equals(that.idShopSite) : that.idShopSite != null) return false;
        if (isSolde != null ? !isSolde.equals(that.isSolde) : that.isSolde != null) return false;
        if (reason != that.reason) return false;
        if (storeid != null ? !storeid.equals(that.storeid) : that.storeid != null) return false;
        if (trafficId != null ? !trafficId.equals(that.trafficId) : that.trafficId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (isError ? 1 : 0);
        result = 31 * result + (isBlacklisted ? 1 : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (storeid != null ? storeid.hashCode() : 0);
        result = 31 * result + (catId != null ? catId.hashCode() : 0);
        result = 31 * result + (idShopSite != null ? idShopSite.hashCode() : 0);
        result = 31 * result + (idAction != null ? idAction.hashCode() : 0);
        result = 31 * result + (isSolde != null ? isSolde.hashCode() : 0);
        result = 31 * result + (trafficId != null ? trafficId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CiaoIntegrationMappingPOJO{" +
                "isError=" + isError +
                ", isBlacklisted=" + isBlacklisted +
                ", reason=" + reason +
                ", country='" + country + '\'' +
                ", storeid=" + storeid +
                ", catId=" + catId +
                ", idShopSite=" + idShopSite +
                ", idAction=" + idAction +
                ", isSolde=" + isSolde +
                ", trafficId=" + trafficId +
                '}';
    }
}
