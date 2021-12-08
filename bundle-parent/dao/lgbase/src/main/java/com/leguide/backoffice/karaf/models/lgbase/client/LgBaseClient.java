package com.leguide.backoffice.karaf.models.lgbase.client;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lg_client")
public class LgBaseClient {
	@Id
	@Column(name = "client_id")
	private String clientId;
	@Column(name = "group_id")
	private Long groupId;
	@Column(name = "create_date")
	private Date creationDate;
	@Column(name = "is_sage")
	private boolean sage;
	@Column(name = "send_invoice")
	private boolean sendInvoice;
	@Column(name="payment_mean_type", columnDefinition="varchar(50)")
	private String paymentMeanType;
	
	@PrimaryKeyJoinColumn
	@OneToOne(cascade={CascadeType.ALL})
	private LgBaseClientInfos infos;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public boolean isSage() {
		return sage;
	}
	public void setSage(boolean sage) {
		this.sage = sage;
	}
	public boolean isSendInvoice() {
		return sendInvoice;
	}
	public void setSendInvoice(boolean sendInvoice) {
		this.sendInvoice = sendInvoice;
	}
//	public PaymentMeanType getPaymentMean() {
//		return PaymentMeanTypeEnum.getPaymentMeanTypeByCode(paymentMeanType);
//	}
//	public void setPaymentMean(PaymentMeanType paymentMeanType) {
//		if(paymentMeanType != null)
//			this.paymentMeanType = paymentMeanType.getCode();
//	}
    public String getPaymentMeanType() {
        return paymentMeanType;
    }
    public void setPaymentMeanType(String paymentMeanType) {
        this.paymentMeanType = paymentMeanType;
    }
    public LgBaseClientInfos getInfos() {
		return infos;
	}
	public void setInfos(LgBaseClientInfos infos) {
		this.infos = infos;
	}
	
}
