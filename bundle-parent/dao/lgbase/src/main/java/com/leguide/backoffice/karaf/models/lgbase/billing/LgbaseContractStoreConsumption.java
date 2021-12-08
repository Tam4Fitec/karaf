package com.leguide.backoffice.karaf.models.lgbase.billing;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "billing_contract_store_consumption")
@NamedQueries({
        @NamedQuery(name = "ContractStoreConsumption.FIND_BY_STORE_FROM_DATE", query = "Select c FROM LgbaseContractStoreConsumption c " +
                "WHERE c.storeUid = :storeUid AND c.startDate > :startDate ORDER BY c.startDate DESC"),
        @NamedQuery(name = "ContractStoreConsumption.FIND_BY_STORE_AT_DATE", query = "Select c FROM LgbaseContractStoreConsumption c " +
                "WHERE c.storeUid = :storeUid AND c.startDate = :startDate")
})
public class LgbaseContractStoreConsumption implements Serializable {

    private static final long serialVersionUID = 2027058719710903021L;

    public static final String FIND_BY_STORE_FROM_DATE = "ContractStoreConsumption.FIND_BY_STORE_FROM_DATE";
    public static final String FIND_BY_STORE_AT_DATE = "ContractStoreConsumption.FIND_BY_STORE_AT_DATE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consumption_id")
    private Long consumptionId;

    @Column(name = "contract_code")
    private String contractCode;

    @Column(name = "store_uid")
    private Long storeUid;

    @Column(name = "consumption_type")
    private String consumptionType;

    @Column(name = "current_amount")
    private Double currentAmount;

    @Column(name = "maximum_amount")
    private Double maximumAmount;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "amount_alert")
    private String amountAlert;

    public Long getConsumptionId() {
        return consumptionId;
    }

    public void setConsumptionId(Long consumptionId) {
        this.consumptionId = consumptionId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Long getStoreUid() {
        return storeUid;
    }

    public void setStoreUid(Long storeUid) {
        this.storeUid = storeUid;
    }

    public String getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(String consumptionType) {
        this.consumptionType = consumptionType;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Double getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Double maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAmountAlert() {
        return amountAlert;
    }

    public void setAmountAlert(String amountAlert) {
        this.amountAlert = amountAlert;
    }

    @Override
    public String toString() {
        return "LgbaseContractStoreConsumption{" +
                "consumptionId=" + consumptionId +
                ", contractCode='" + contractCode + '\'' +
                ", storeUid=" + storeUid +
                ", consumptionType='" + consumptionType + '\'' +
                ", currentAmount=" + currentAmount +
                ", maximumAmount=" + maximumAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createDate=" + createDate +
                ", orderId=" + orderId +
                ", amountAlert='" + amountAlert + '\'' +
                '}';
    }
}
