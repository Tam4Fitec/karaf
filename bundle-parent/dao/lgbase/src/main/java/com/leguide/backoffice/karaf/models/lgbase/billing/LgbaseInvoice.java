package com.leguide.backoffice.karaf.models.lgbase.billing;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "billing_invoice")
@NamedQueries({
    @NamedQuery(name = LgbaseInvoice.FIND_LAST_INVOICES, query = "Select i FROM LgbaseInvoice i WHERE i.clientId = :clientId ORDER BY i.invoiceDate DESC")
})
@NamedNativeQueries({
    @NamedNativeQuery(name = LgbaseInvoice.FIND_ALL_INVOICES_FOR_CB_CLIENTS_EDITED_IN_MONTH,
        	query = "SELECT inv.* FROM billing_invoice inv "
        			+ " INNER JOIN lg_ecritures ecr on inv.invoice_code = ecr.ref_interne AND ecr.sens = 'D' "
        			+ " INNER JOIN lg_client cli on cli.client_id = inv.client_id and cli.payment_mean_type = 'BANK_CARD' "
        			+ " WHERE inv.invoice_date between ? and ?", resultClass = LgbaseInvoice.class),
    @NamedNativeQuery(name = LgbaseInvoice.FIND_LAST_WRITED_INVOICES, query = "Select inv.* FROM billing_invoice inv INNER JOIN lg_ecritures ecr on inv.invoice_code = ecr.ref_interne and ecr.sens = 'D' WHERE inv.client_id = ? ORDER BY inv.invoice_date DESC", resultClass = LgbaseInvoice.class)

})
public class LgbaseInvoice {

    public static final String FIND_LAST_INVOICES = "LgbaseInvoice.FIND_LAST_INVOICES";
    public static final String FIND_LAST_WRITED_INVOICES = "LgbaseInvoice.FIND_LAST_WRITED_INVOICES";
    public static final String FIND_ALL_INVOICES_FOR_CB_CLIENTS_EDITED_IN_MONTH = "LgbaseInvoice.FIND_ALL_INVOICES_FOR_CB_CLIENTS_EDITED_IN_MONTH";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_code")
    private Long invoiceCode;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "xml")
    private String xml;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "invoice_status")
    private String invoiceStatus;

    @Column(name = "invoice_date")
    private Date invoiceDate;

    @Column(name = "amount_net")
    private Double amountNet;

    @Column(name = "amount_with_tax")
    private Double amountWithTax;

    @Column(name = "clic_nb")
    private Long clicNb;

    @Column(name = "amount_cpc_net")
    private Double amountCpcNet;

    @Column(name = "payment_status")
    private String paymentStatus;

    public Long getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(Long invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Double getAmountNet() {
        return amountNet;
    }

    public void setAmountNet(Double amountNet) {
        this.amountNet = amountNet;
    }

    public Double getAmountWithTax() {
        return amountWithTax;
    }

    public void setAmountWithTax(Double amountWithTax) {
        this.amountWithTax = amountWithTax;
    }

    public Long getClicNb() {
        return clicNb;
    }

    public void setClicNb(Long clicNb) {
        this.clicNb = clicNb;
    }

    public Double getAmountCpcNet() {
        return amountCpcNet;
    }

    public void setAmountCpcNet(Double amountCpcNet) {
        this.amountCpcNet = amountCpcNet;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
