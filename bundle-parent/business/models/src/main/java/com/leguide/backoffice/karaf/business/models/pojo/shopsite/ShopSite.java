package com.leguide.backoffice.karaf.business.models.pojo.shopsite;

import com.leguide.backoffice.karaf.business.models.pojo.Account;
import com.leguide.backoffice.karaf.business.models.pojo.Model;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ShopSiteState;

import java.util.Date;

public class ShopSite extends Model {

    private static final long serialVersionUID = 5843881044257893039L;

    private Long shopSiteId;

    private ShopSiteSociety society;
    private ShopSiteState state;
    private Account account;
    private ShopSiteDelivery delivery;
    private ShopSiteSecurity security;
    private ShopSitePrivacyPolicy privacyPolicy;
    private ShopSiteInternalNotification internalNotification;

    private String name;
    private String country;
    private Integer countryInternalCode;
    private String language;
    private Integer languageId;
    private String deliveryCountry;
    private String phoneCustomerSupport;
    private String faxCustomerSupport;
    private String emailCustomerSupport;
    private Long selfcareAccountId;
    private String source;

    // To delete later
    private String clicTypeMdm;
    private String shopStateMdm;

    // Offers count
    private Long offersCount;

    // Urls
    private String url;
    private String urlTracked;
    private String urlLogo;

    // Description
    private String generalDescription;
    private String detailsDescription;

    //labels of the sites where the shopsite is displayed ( from the ksite mask)
    private String displayedOn;

    private String physicalShop;

    private Integer refState;

    private String leadId;

    private String seqDeliveryZone;

    private Integer zeusNotation;

    private Boolean logoToReview;

    private Boolean transfoTracked;

    private Boolean mobileFriendly;

    private Boolean pricing;
    private String pricingStartDate;
    private String pricingEndDate;
    private String pricingType;
    private Date createDate;

    private String catalogUrl;

    public Long getShopSiteId() {
        return shopSiteId;
    }

    public void setShopSiteId(Long shopSiteId) {
        this.shopSiteId = shopSiteId;
    }

    public ShopSiteSociety getSociety() {
        return society;
    }

    public void setSociety(ShopSiteSociety society) {
        this.society = society;
    }

    public ShopSiteState getState() {
        return state;
    }

    public void setState(ShopSiteState state) {
        this.state = state;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ShopSiteDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(ShopSiteDelivery delivery) {
        this.delivery = delivery;
    }

    public ShopSiteSecurity getSecurity() {
        return security;
    }

    public void setSecurity(ShopSiteSecurity security) {
        this.security = security;
    }

    public ShopSitePrivacyPolicy getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(ShopSitePrivacyPolicy privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    public ShopSiteInternalNotification getInternalNotification() {
        return internalNotification;
    }

    public void setInternalNotification(ShopSiteInternalNotification internalNotification) {
        this.internalNotification = internalNotification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDeliveryCountry() {
        return deliveryCountry;
    }

    public void setDeliveryCountry(String deliveryCountry) {
        this.deliveryCountry = deliveryCountry;
    }

    public String getPhoneCustomerSupport() {
        return phoneCustomerSupport;
    }

    public void setPhoneCustomerSupport(String phoneCustomerSupport) {
        this.phoneCustomerSupport = phoneCustomerSupport;
    }

    public String getFaxCustomerSupport() {
        return faxCustomerSupport;
    }

    public void setFaxCustomerSupport(String faxCustomerSupport) {
        this.faxCustomerSupport = faxCustomerSupport;
    }

    public String getEmailCustomerSupport() {
        return emailCustomerSupport;
    }

    public void setEmailCustomerSupport(String emailCustomerSupport) {
        this.emailCustomerSupport = emailCustomerSupport;
    }

    public Long getSelfcareAccountId() {
        return selfcareAccountId;
    }

    public void setSelfcareAccountId(Long selfcareAccountId) {
        this.selfcareAccountId = selfcareAccountId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getClicTypeMdm() {
        return clicTypeMdm;
    }

    public void setClicTypeMdm(String clicTypeMdm) {
        this.clicTypeMdm = clicTypeMdm;
    }

    public String getShopStateMdm() {
        return shopStateMdm;
    }

    public void setShopStateMdm(String shopStateMdm) {
        this.shopStateMdm = shopStateMdm;
    }

    public Long getOffersCount() {
        return offersCount;
    }

    public void setOffersCount(Long offersCount) {
        this.offersCount = offersCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlTracked() {
        return urlTracked;
    }

    public void setUrlTracked(String urlTracked) {
        this.urlTracked = urlTracked;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public String getDetailsDescription() {
        return detailsDescription;
    }

    public void setDetailsDescription(String detailsDescription) {
        this.detailsDescription = detailsDescription;
    }

    public String getPhysicalShop() {
        return physicalShop;
    }

    public void setPhysicalShop(String physicalShop) {
        this.physicalShop = physicalShop;
    }

    public String getDisplayedOn() {
        return displayedOn;
    }

    public void setDisplayedOn(String displayedOn) {
        this.displayedOn = displayedOn;
    }

    public Integer getCountryInternalCode() {
        return countryInternalCode;
    }

    public void setCountryInternalCode(Integer countryInternalCode) {
        this.countryInternalCode = countryInternalCode;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getRefState() {
        return refState;
    }

    public void setRefState(Integer refState) {
        this.refState = refState;
    }

    public String getLeadId() {
        return leadId;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public String getSeqDeliveryZone() {
        return seqDeliveryZone;
    }

    public void setSeqDeliveryZone(String seqDeliveryZone) {
        this.seqDeliveryZone = seqDeliveryZone;
    }

    public Integer getZeusNotation() {
        return zeusNotation;
    }

    public void setZeusNotation(Integer zeusNotation) {
        this.zeusNotation = zeusNotation;
    }

    public Boolean getLogoToReview() {
        return logoToReview;
    }

    public void setLogoToReview(Boolean logoToReview) {
        this.logoToReview = logoToReview;
    }

    public Boolean getTransfoTracked() {
        return transfoTracked;
    }

    public void setTransfoTracked(Boolean transfoTracked) {
        this.transfoTracked = transfoTracked;
    }

    public Boolean getPricing() {
        return pricing;
    }

    public void setPricing(Boolean pricing) {
        this.pricing = pricing;
    }

    public String getPricingStartDate() {
        return pricingStartDate;
    }

    public void setPricingStartDate(String pricingStartDate) {
        this.pricingStartDate = pricingStartDate;
    }

    public String getPricingEndDate() {
        return pricingEndDate;
    }

    public void setPricingEndDate(String pricingEndDate) {
        this.pricingEndDate = pricingEndDate;
    }

    public Boolean getMobileFriendly() {
        return mobileFriendly;
    }

    public void setMobileFriendly(Boolean mobileFriendly) {
        this.mobileFriendly = mobileFriendly;
    }

    public String getPricingType() {
        return pricingType;
    }

    public void setPricingType(String pricingType) {
        this.pricingType = pricingType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCatalogUrl() {
        return catalogUrl;
    }

    public void setCatalogUrl(String catalogUrl) {
        this.catalogUrl = catalogUrl;
    }

    @Override
    public String toString() {
        return "ShopSite{" +
                "shopSiteId=" + shopSiteId +
                ", society=" + society +
                ", state=" + state +
                ", account=" + account +
                ", delivery=" + delivery +
                ", security=" + security +
                ", privacyPolicy=" + privacyPolicy +
                ", internalNotification=" + internalNotification +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", countryInternalCode=" + countryInternalCode +
                ", language='" + language + '\'' +
                ", languageId=" + languageId +
                ", deliveryCountry='" + deliveryCountry + '\'' +
                ", phoneCustomerSupport='" + phoneCustomerSupport + '\'' +
                ", faxCustomerSupport='" + faxCustomerSupport + '\'' +
                ", emailCustomerSupport='" + emailCustomerSupport + '\'' +
                ", selfcareAccountId=" + selfcareAccountId +
                ", source='" + source + '\'' +
                ", clicTypeMdm='" + clicTypeMdm + '\'' +
                ", shopStateMdm='" + shopStateMdm + '\'' +
                ", offersCount=" + offersCount +
                ", url='" + url + '\'' +
                ", urlTracked='" + urlTracked + '\'' +
                ", urlLogo='" + urlLogo + '\'' +
                ", generalDescription='" + generalDescription + '\'' +
                ", detailsDescription='" + detailsDescription + '\'' +
                ", displayedOn='" + displayedOn + '\'' +
                ", physicalShop='" + physicalShop + '\'' +
                ", refState=" + refState +
                ", leadId='" + leadId + '\'' +
                ", seqDeliveryZone='" + seqDeliveryZone + '\'' +
                ", zeusNotation=" + zeusNotation +
                ", logoToReview=" + logoToReview +
                ", transfoTracked=" + transfoTracked +
                ", mobileFriendly=" + mobileFriendly +
                ", pricing=" + pricing +
                ", pricingStartDate='" + pricingStartDate + '\'' +
                ", pricingEndDate='" + pricingEndDate + '\'' +
                ", pricingType='" + pricingType + '\'' +
                ", createDate=" + createDate +
                ", catalogUrl='" + catalogUrl + '\'' +
                '}';
    }
}
