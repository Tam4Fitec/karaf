package com.leguide.backoffice.karaf.business.models.ciaointegration;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement
/**
 * object representation of a clic. converts date column to Date object
 * @author jlboulanger
 *
 */
public class CiaoIntegrationPOJO implements Serializable {
    private static final long serialVersionUID = -5731558367011540542L;

    private CiaoIntegrationMappingPOJO mapping = null;
    //date of the clic
    private Date date = null;
    //country_code
    private String country = null;
    //ciao_cust_id
    private Long customerId = null; //CIAO customer id, to map with LG shopsite id
    //country for the referent
    private String countryRef = "";
    //ref customer id. Will be the same than customerId if no referent
    private Long customerIdRef = null;
    //lg_cat_id
    private Long providedLGCategory = null; //CIAO sends the LG cat ID stored in their system. Use the mapping if null
    //lg_shopsite_id
    private Long providedLGShopsite = null; //CIAO sends the LG shopsite ID stored in their system. Use the mapping if null
    //ciao_offer_id
    private String offerId = null; //CIAO offer id
    //ciao_cat_id
    private String catPath = null; // comma separated list of CIAO cat_id. The last is the one to map
    //ciao_unique_id
    private String uniqueID = null; //unique click identifier
    //offer_shopsite_url
    private String offerShopsiteUrl = null; //    url of the offer on the merchant site
    //search_expression
    private String searchExpr = null;//the search keywords at the origin of the click
    //sem_keys
    private String semKeys = null; // the SEM keywords at the origin of the click
    //original clic
    private String fromClic = null;//the origin url
    //origin ip
    private String ip;
    //item key
    private String itemKey = null;
    //placement id
    private Integer ciaoPlacementId = null;
    //ciao click type
    private String ciaoClickType = null;
    // userAgent
    private String userAgent = null;
    // CK_SLKW3 - keyword
    private String keyword = null;
    // CK_PUBLISHER - traffic_origin
    private String trafficOrigin = null;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProvidedLGCategory() {
        return providedLGCategory;
    }

    public void setProvidedLGCategory(Long providedLGCategory) {
        this.providedLGCategory = providedLGCategory;
    }

    public Long getProvidedLGShopsite() {
        return providedLGShopsite;
    }

    public void setProvidedLGShopsite(Long providedLGShopsite) {
        this.providedLGShopsite = providedLGShopsite;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getCatPath() {
        return catPath;
    }

    public void setCatPath(String catPath) {
        this.catPath = catPath;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getOfferShopsiteUrl() {
        return offerShopsiteUrl;
    }

    public void setOfferShopsiteUrl(String offerShopsiteUrl) {
        this.offerShopsiteUrl = offerShopsiteUrl;
    }

    public String getSearchExpr() {
        return searchExpr;
    }

    public void setSearchExpr(String searchExpr) {
        this.searchExpr = searchExpr;
    }

    public String getSemKeys() {
        return semKeys;
    }

    public void setSemKeys(String semKeys) {
        this.semKeys = semKeys;
    }

    public String getFromClic() {
        return fromClic;
    }

    public void setFromClic(String fromClic) {
        this.fromClic = fromClic;
    }

    public CiaoIntegrationMappingPOJO getMapping() {
        return mapping;
    }

    public void setMapping(CiaoIntegrationMappingPOJO mapping) {
        this.mapping = mapping;
    }

    public String getCountryRef() {
        return countryRef;
    }

    public void setCountryRef(String countryRef) {
        this.countryRef = countryRef;
    }

    public Long getCustomerIdRef() {
        return customerIdRef;
    }

    public void setCustomerIdRef(Long customerIdRef) {
        this.customerIdRef = customerIdRef;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public Integer getCiaoPlacementId() {
        return ciaoPlacementId;
    }

    public void setCiaoPlacementId(Integer ciaoPlacementId) {
        this.ciaoPlacementId = ciaoPlacementId;
    }

    public String getCiaoClickType() {
        return ciaoClickType;
    }

    public void setCiaoClickType(String ciaoClickType) {
        this.ciaoClickType = ciaoClickType;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTrafficOrigin() {
        return trafficOrigin;
    }

    public void setTrafficOrigin(String trafficOrigin) {
        this.trafficOrigin = trafficOrigin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CiaoIntegrationPOJO that = (CiaoIntegrationPOJO) o;

        if (catPath != null ? !catPath.equals(that.catPath) : that.catPath != null) return false;
        if (ciaoClickType != null ? !ciaoClickType.equals(that.ciaoClickType) : that.ciaoClickType != null)
            return false;
        if (ciaoPlacementId != null ? !ciaoPlacementId.equals(that.ciaoPlacementId) : that.ciaoPlacementId != null)
            return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (countryRef != null ? !countryRef.equals(that.countryRef) : that.countryRef != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (customerIdRef != null ? !customerIdRef.equals(that.customerIdRef) : that.customerIdRef != null)
            return false;
        if (fromClic != null ? !fromClic.equals(that.fromClic) : that.fromClic != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (itemKey != null ? !itemKey.equals(that.itemKey) : that.itemKey != null) return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;
        if (offerId != null ? !offerId.equals(that.offerId) : that.offerId != null) return false;
        if (offerShopsiteUrl != null ? !offerShopsiteUrl.equals(that.offerShopsiteUrl) : that.offerShopsiteUrl != null)
            return false;
        if (providedLGCategory != null ? !providedLGCategory.equals(that.providedLGCategory) : that.providedLGCategory != null)
            return false;
        if (providedLGShopsite != null ? !providedLGShopsite.equals(that.providedLGShopsite) : that.providedLGShopsite != null)
            return false;
        if (searchExpr != null ? !searchExpr.equals(that.searchExpr) : that.searchExpr != null) return false;
        if (semKeys != null ? !semKeys.equals(that.semKeys) : that.semKeys != null) return false;
        if (trafficOrigin != null ? !trafficOrigin.equals(that.trafficOrigin) : that.trafficOrigin != null)
            return false;
        if (uniqueID != null ? !uniqueID.equals(that.uniqueID) : that.uniqueID != null) return false;
        if (userAgent != null ? !userAgent.equals(that.userAgent) : that.userAgent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (countryRef != null ? countryRef.hashCode() : 0);
        result = 31 * result + (customerIdRef != null ? customerIdRef.hashCode() : 0);
        result = 31 * result + (providedLGCategory != null ? providedLGCategory.hashCode() : 0);
        result = 31 * result + (providedLGShopsite != null ? providedLGShopsite.hashCode() : 0);
        result = 31 * result + (offerId != null ? offerId.hashCode() : 0);
        result = 31 * result + (catPath != null ? catPath.hashCode() : 0);
        result = 31 * result + (uniqueID != null ? uniqueID.hashCode() : 0);
        result = 31 * result + (offerShopsiteUrl != null ? offerShopsiteUrl.hashCode() : 0);
        result = 31 * result + (searchExpr != null ? searchExpr.hashCode() : 0);
        result = 31 * result + (semKeys != null ? semKeys.hashCode() : 0);
        result = 31 * result + (fromClic != null ? fromClic.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (itemKey != null ? itemKey.hashCode() : 0);
        result = 31 * result + (ciaoPlacementId != null ? ciaoPlacementId.hashCode() : 0);
        result = 31 * result + (ciaoClickType != null ? ciaoClickType.hashCode() : 0);
        result = 31 * result + (userAgent != null ? userAgent.hashCode() : 0);
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (trafficOrigin != null ? trafficOrigin.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CiaoIntegrationPOJO{" +
                "mapping=" + mapping +
                ", date=" + date +
                ", country='" + country + '\'' +
                ", customerId=" + customerId +
                ", countryRef='" + countryRef + '\'' +
                ", customerIdRef=" + customerIdRef +
                ", providedLGCategory=" + providedLGCategory +
                ", providedLGShopsite=" + providedLGShopsite +
                ", offerId='" + offerId + '\'' +
                ", catPath='" + catPath + '\'' +
                ", uniqueID='" + uniqueID + '\'' +
                ", offerShopsiteUrl='" + offerShopsiteUrl + '\'' +
                ", searchExpr='" + searchExpr + '\'' +
                ", semKeys='" + semKeys + '\'' +
                ", fromClic='" + fromClic + '\'' +
                ", ip='" + ip + '\'' +
                ", itemKey='" + itemKey + '\'' +
                ", ciaoPlacementId=" + ciaoPlacementId +
                ", ciaoClickType='" + ciaoClickType + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", keyword='" + keyword + '\'' +
                ", trafficOrigin='" + trafficOrigin + '\'' +
                '}';
    }
}
