package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_shopsite_privacy_policy")
public class LgshopShopsitePrivacyPolicy implements Serializable {

    private static final long serialVersionUID = -270986054246640206L;

    @Id
    @Column(name = "id_shopsite")
    private Long shopsiteId;

    @Column(name = "spp_data_encryption")
    private String dataEncryption = "N";

    @Column(name = "spp_personal_data_shared")
    private String personalDataShared = "N";

    @Column(name = "spp_personal_data_selled")
    private String personalDataSelled = "N";

    @Column(name = "spp_authorization_asked")
    private String authorizationAsked = "N";

    @Column(name = "spp_gift_wrapping")
    private String giftWrapping = "N";

    @Column(name = "spp_cater_to_individuals")
    private String caterToIndividuals = "N";

    @Column(name = "spp_cater_to_professionals")
    private String caterToProfessionals = "N";

    @Column(name = "spp_open_user_accounts")
    private String openUserAccounts = "N";

    @Column(name = "spp_loyalty_program")
    private String loyaltyProgram = "N";

    @Column(name = "spp_security_protocol_other")
    private String securityProtocolOther;

    @Column(name = "spp_quality_labelling_other")
    private String qualityLabellingOther;

    @Column(name = "spp_order_without_user_account")
    private String orderWithoutUserAccount;

    @Column(name = "spp_systematic_garantee_on_products")
    private String systematicGuaranteeOnProducts;

    @Column(name = "spp_systematic_garantee_on_products_infos")
    private String systematicGuaranteeOnProductsInfos;

    @Column(name = "spp_mobile_friendly")
    private String mobileFriendly = "N";

    public Long getShopsiteId() {
        return shopsiteId;
    }

    public void setShopsiteId(Long shopsiteId) {
        this.shopsiteId = shopsiteId;
    }

    public String getDataEncryption() {
        return dataEncryption;
    }

    public void setDataEncryption(String dataEncryption) {
        this.dataEncryption = dataEncryption;
    }

    public String getPersonalDataShared() {
        return personalDataShared;
    }

    public void setPersonalDataShared(String personalDataShared) {
        this.personalDataShared = personalDataShared;
    }

    public String getPersonalDataSelled() {
        return personalDataSelled;
    }

    public void setPersonalDataSelled(String personalDataSelled) {
        this.personalDataSelled = personalDataSelled;
    }

    public String getAuthorizationAsked() {
        return authorizationAsked;
    }

    public void setAuthorizationAsked(String authorizationAsked) {
        this.authorizationAsked = authorizationAsked;
    }

    public String getGiftWrapping() {
        return giftWrapping;
    }

    public void setGiftWrapping(String giftWrapping) {
        this.giftWrapping = giftWrapping;
    }

    public String getCaterToIndividuals() {
        return caterToIndividuals;
    }

    public void setCaterToIndividuals(String caterToIndividuals) {
        this.caterToIndividuals = caterToIndividuals;
    }

    public String getCaterToProfessionals() {
        return caterToProfessionals;
    }

    public void setCaterToProfessionals(String caterToProfessionals) {
        this.caterToProfessionals = caterToProfessionals;
    }

    public String getOpenUserAccounts() {
        return openUserAccounts;
    }

    public void setOpenUserAccounts(String openUserAccounts) {
        this.openUserAccounts = openUserAccounts;
    }

    public String getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public void setLoyaltyProgram(String loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }

    public String getSecurityProtocolOther() {
        return securityProtocolOther;
    }

    public void setSecurityProtocolOther(String securityProtocolOther) {
        this.securityProtocolOther = securityProtocolOther;
    }

    public String getQualityLabellingOther() {
        return qualityLabellingOther;
    }

    public void setQualityLabellingOther(String qualityLabellingOther) {
        this.qualityLabellingOther = qualityLabellingOther;
    }

    public String getOrderWithoutUserAccount() {
        return orderWithoutUserAccount;
    }

    public void setOrderWithoutUserAccount(String orderWithoutUserAccount) {
        this.orderWithoutUserAccount = orderWithoutUserAccount;
    }

    public String getSystematicGuaranteeOnProducts() {
        return systematicGuaranteeOnProducts;
    }

    public void setSystematicGuaranteeOnProducts(String systematicGuaranteeOnProducts) {
        this.systematicGuaranteeOnProducts = systematicGuaranteeOnProducts;
    }

    public String getSystematicGuaranteeOnProductsInfos() {
        return systematicGuaranteeOnProductsInfos;
    }

    public void setSystematicGuaranteeOnProductsInfos(String systematicGuaranteeOnProductsInfos) {
        this.systematicGuaranteeOnProductsInfos = systematicGuaranteeOnProductsInfos;
    }

    public String getMobileFriendly() {
        return mobileFriendly;
    }

    public void setMobileFriendly(String mobileFriendly) {
        this.mobileFriendly = mobileFriendly;
    }
}
