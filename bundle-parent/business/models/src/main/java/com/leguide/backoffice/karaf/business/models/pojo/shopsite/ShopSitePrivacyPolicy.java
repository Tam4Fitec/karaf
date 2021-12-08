package com.leguide.backoffice.karaf.business.models.pojo.shopsite;

import java.util.List;

public class ShopSitePrivacyPolicy {

    private String caterToIndividuals;

    private String caterToProfessionals;

    private String clientAccount;

    private String loyaltyProgram;

    private String giftWrapping;

    private List<Integer> commandModes;

    private String mobileFriendly;

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

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(String clientAccount) {
        this.clientAccount = clientAccount;
    }

    public String getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public void setLoyaltyProgram(String loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }

    public String getGiftWrapping() {
        return giftWrapping;
    }

    public void setGiftWrapping(String giftWrapping) {
        this.giftWrapping = giftWrapping;
    }

    public List<Integer> getCommandModes() {
        return commandModes;
    }

    public void setCommandModes(List<Integer> commandModes) {
        this.commandModes = commandModes;
    }

    public String getMobileFriendly() {
        return mobileFriendly;
    }

    public void setMobileFriendly(String mobileFriendly) {
        this.mobileFriendly = mobileFriendly;
    }
}
