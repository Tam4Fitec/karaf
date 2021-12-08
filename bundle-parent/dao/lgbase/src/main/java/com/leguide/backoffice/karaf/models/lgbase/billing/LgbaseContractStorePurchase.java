package com.leguide.backoffice.karaf.models.lgbase.billing;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "billing_contract_store_purchase")
@NamedQueries({
        @NamedQuery(name = "LgbaseContractStorePurchase.FIND_SHOPSITE_CURRENT_PURCHASE", query = "Select SUM(csp.amount), SUM(csp.clicNb), AVG(csp.cpc) " +
                "FROM LgbaseContractStorePurchase csp " +
                "WHERE csp.storeUid = :storeUid AND csp.createDate >= :begin AND csp.createDate <= :end ")
})
public class LgbaseContractStorePurchase implements Serializable {

    private static final long serialVersionUID = -6095240806185836072L;

    public static final String FIND_SHOPSITE_CURRENT_PURCHASE = "LgbaseContractStorePurchase.FIND_SHOPSITE_CURRENT_PURCHASE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long purchaseId;

    @Column(name = "contract_code")
    private String contractCode;

    @Column(name = "store_uid")
    private Long storeUid;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "cpc")
    private Double cpc;

    @Column(name = "clic_nb")
    private Long clicNb;

    @Column(name = "invoice_status")
    private Integer invoiceStatus;

    @Column(name = "purchase_type")
    private String purchaseType;

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCpc() {
        return cpc;
    }

    public void setCpc(Double cpc) {
        this.cpc = cpc;
    }

    public Long getClicNb() {
        return clicNb;
    }

    public void setClicNb(Long clicNb) {
        this.clicNb = clicNb;
    }

    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }
}
