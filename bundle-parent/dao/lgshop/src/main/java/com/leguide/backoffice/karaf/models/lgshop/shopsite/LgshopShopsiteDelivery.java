package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_shopsite_delivery")
public class LgshopShopsiteDelivery implements Serializable {

    private static final long serialVersionUID = -4620429132812287001L;

    @Id
    @Column(name = "id_shopsite")
    private Long shopsiteId;

    @Column(name = "shd_cooling_off_period")
    private Long coolingOffPeriod;

    @Column(name = "shd_applicable_all_products")
    private String applicableAllProducts;

    @Column(name = "shd_multiple_address")
    private String multipleAddress;

    @Column(name = "shd_multiple_person")
    private String multiplePerson;

    @Column(name = "shd_order_tracking")
    private String orderTracking;

    @Column(name = "shd_free")
    private String free;

    @Column(name = "shd_free_on_over")
    private Integer freeOnOver;

    @Column(name = "shd_express")
    private String express;

    @Column(name = "shd_wedding_list")
    private String weddingList;

    @Column(name = "shd_additional_remarks")
    private String additionalRemarks;

    @Column(name = "shd_command_phone_number")
    private String commandPhoneNumber;

    @Column(name = "shd_payment_mode_other")
    private String paymentModeOther;

    @Column(name = "shd_store_card")
    private String storeCard;

    @Column(name = "shd_store_card_info")
    private String storeCardInfo;

    @Column(name = "shd_interest_free_credit")
    private String interestFreeCredit;

    @Column(name = "shd_interest_free_credit_info")
    private String interestFreeCreditInfo;

    @Column(name = "shd_delivery_mode_other")
    private String deliveryModeOther;

    @Column(name = "shd_pick_up_point")
    private String pickUpPoint;

    @Column(name = "shd_pick_up_point_other")
    private String pickUpPointOther;

    @Column(name = "shd_payment_when_sent")
    private String paymentWhenSent;

    @Column(name = "shd_payment_after_client_checking")
    private String paymentAfterClientChecking;

    @Column(name = "shd_home_installation")
    private String homeInstallation;

    @Column(name = "shd_previous_material_removal")
    private String previousMaterialRemoval;

    @Column(name = "shd_home_repairs")
    private String homeRepairs;

    @Column(name = "shd_in_store_pick_up")
    private String inStorePickUp;

    @Column(name = "shd_in_store_pick_up_from")
    private String inStorePickUpFrom;

    @Column(name = "shd_in_store_pick_up_infos")
    private String inStorePickUpInfos;

    public Long getShopsiteId() {
        return shopsiteId;
    }

    public void setShopsiteId(Long shopsiteId) {
        this.shopsiteId = shopsiteId;
    }

    public Long getCoolingOffPeriod() {
        return coolingOffPeriod;
    }

    public void setCoolingOffPeriod(Long coolingOffPeriod) {
        this.coolingOffPeriod = coolingOffPeriod;
    }

    public String getApplicableAllProducts() {
        return applicableAllProducts;
    }

    public void setApplicableAllProducts(String applicableAllProducts) {
        this.applicableAllProducts = applicableAllProducts;
    }

    public String getMultipleAddress() {
        return multipleAddress;
    }

    public void setMultipleAddress(String multipleAddress) {
        this.multipleAddress = multipleAddress;
    }

    public String getMultiplePerson() {
        return multiplePerson;
    }

    public void setMultiplePerson(String multiplePerson) {
        this.multiplePerson = multiplePerson;
    }

    public String getOrderTracking() {
        return orderTracking;
    }

    public void setOrderTracking(String orderTracking) {
        this.orderTracking = orderTracking;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public Integer getFreeOnOver() {
        return freeOnOver;
    }

    public void setFreeOnOver(Integer freeOnOver) {
        this.freeOnOver = freeOnOver;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public String getWeddingList() {
        return weddingList;
    }

    public void setWeddingList(String weddingList) {
        this.weddingList = weddingList;
    }

    public String getAdditionalRemarks() {
        return additionalRemarks;
    }

    public void setAdditionalRemarks(String additionalRemarks) {
        this.additionalRemarks = additionalRemarks;
    }

    public String getCommandPhoneNumber() {
        return commandPhoneNumber;
    }

    public void setCommandPhoneNumber(String commandPhoneNumber) {
        this.commandPhoneNumber = commandPhoneNumber;
    }

    public String getPaymentModeOther() {
        return paymentModeOther;
    }

    public void setPaymentModeOther(String paymentModeOther) {
        this.paymentModeOther = paymentModeOther;
    }

    public String getStoreCard() {
        return storeCard;
    }

    public void setStoreCard(String storeCard) {
        this.storeCard = storeCard;
    }

    public String getStoreCardInfo() {
        return storeCardInfo;
    }

    public void setStoreCardInfo(String storeCardInfo) {
        this.storeCardInfo = storeCardInfo;
    }

    public String getInterestFreeCredit() {
        return interestFreeCredit;
    }

    public void setInterestFreeCredit(String interestFreeCredit) {
        this.interestFreeCredit = interestFreeCredit;
    }

    public String getInterestFreeCreditInfo() {
        return interestFreeCreditInfo;
    }

    public void setInterestFreeCreditInfo(String interestFreeCreditInfo) {
        this.interestFreeCreditInfo = interestFreeCreditInfo;
    }

    public String getDeliveryModeOther() {
        return deliveryModeOther;
    }

    public void setDeliveryModeOther(String deliveryModeOther) {
        this.deliveryModeOther = deliveryModeOther;
    }

    public String getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(String pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public String getPickUpPointOther() {
        return pickUpPointOther;
    }

    public void setPickUpPointOther(String pickUpPointOther) {
        this.pickUpPointOther = pickUpPointOther;
    }

    public String getPaymentWhenSent() {
        return paymentWhenSent;
    }

    public void setPaymentWhenSent(String paymentWhenSent) {
        this.paymentWhenSent = paymentWhenSent;
    }

    public String getPaymentAfterClientChecking() {
        return paymentAfterClientChecking;
    }

    public void setPaymentAfterClientChecking(String paymentAfterClientChecking) {
        this.paymentAfterClientChecking = paymentAfterClientChecking;
    }

    public String getHomeInstallation() {
        return homeInstallation;
    }

    public void setHomeInstallation(String homeInstallation) {
        this.homeInstallation = homeInstallation;
    }

    public String getPreviousMaterialRemoval() {
        return previousMaterialRemoval;
    }

    public void setPreviousMaterialRemoval(String previousMaterialRemoval) {
        this.previousMaterialRemoval = previousMaterialRemoval;
    }

    public String getHomeRepairs() {
        return homeRepairs;
    }

    public void setHomeRepairs(String homeRepairs) {
        this.homeRepairs = homeRepairs;
    }

    public String getInStorePickUp() {
        return inStorePickUp;
    }

    public void setInStorePickUp(String inStorePickUp) {
        this.inStorePickUp = inStorePickUp;
    }

    public String getInStorePickUpFrom() {
        return inStorePickUpFrom;
    }

    public void setInStorePickUpFrom(String inStorePickUpFrom) {
        this.inStorePickUpFrom = inStorePickUpFrom;
    }

    public String getInStorePickUpInfos() {
        return inStorePickUpInfos;
    }

    public void setInStorePickUpInfos(String inStorePickUpInfos) {
        this.inStorePickUpInfos = inStorePickUpInfos;
    }
}
