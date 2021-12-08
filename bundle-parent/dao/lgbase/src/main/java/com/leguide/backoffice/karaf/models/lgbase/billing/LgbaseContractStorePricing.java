package com.leguide.backoffice.karaf.models.lgbase.billing;

import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "billing_contract_store_pricing")
@NamedQueries({
        @NamedQuery(name = LgbaseContractStorePricing.GET_LAST_PRICING_CONTRACTS_FROM_DATE, 
        			query = "Select c FROM LgbaseContractStorePricing c WHERE c.clientId = :clientId and startDate >= :startDate order by startDate desc")
})
public class LgbaseContractStorePricing implements Serializable {
    private static final long serialVersionUID = 2027058719710903021L;

    public static final String GET_LAST_PRICING_CONTRACTS_FROM_DATE = "LgbaseContractStorePricing.GET_LAST_PRICING_CONTRACTS_FROM_DATE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client_code")
    private String clientId;

    @Column(name = "contract_code")
    private String contractCode;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "store_uid")
    private Long shopsiteId;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public Long getShopsiteId() {
		return shopsiteId;
	}

	public void setShopsiteId(Long shopsiteId) {
		this.shopsiteId = shopsiteId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
