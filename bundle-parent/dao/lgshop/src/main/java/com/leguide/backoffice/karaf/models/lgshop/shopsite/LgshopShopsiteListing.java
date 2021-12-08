package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="tb_shopsite_listing")
@XmlRootElement(name = "LgshopShopsiteListing")
public class LgshopShopsiteListing implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 6309795538850175398L;

	@Id
	@Column(name="id_shopsite")
	private Long shopsiteId;
	
	@Column(name="shl_general_description")
	private String generalDescription;
	
	@Column(name="shl_details_description")
	private String detailsDescription;
	
	@Column(name="shl_physical_shop")
	private String physicalShop;
	
	@Column(name="shl_physical_shop_referencing")
	private Integer physicalShopReferencing;
	
	@Column(name="shl_e_commerce_solution")
	private String eCommerceSolution;
	
	@Column(name="shl_e_commerce_solution_referencing")
	private Integer eCommerceSolutionRef;
	
	@Column(name="shl_customer_service_phone_number")
	private String customerServicePhone;
	
	@Column(name="shl_customer_service_fax_number")
	private String customerServiceFax;
	
	@Column(name="shl_customer_service_email")
	private String customerServiceEmail;
	
	@Column(name="id_language")
	private Integer languageId;
	
	@Column(name="shl_customer_service_rate")
	private String customerServiceRate;
	
	@Column(name="shl_customer_service_opening_schedules")
	private String customerServiceSchedules;

	/**
	 * @return the shopsiteId
	 */
	public Long getShopsiteId() {
		return shopsiteId;
	}

	/**
	 * @param shopsiteId the shopsiteId to set
	 */
	public void setShopsiteId(Long shopsiteId) {
		this.shopsiteId = shopsiteId;
	}

	/**
	 * @return the generalDescription
	 */
	public String getGeneralDescription() {
		return generalDescription;
	}

	/**
	 * @param generalDescription the generalDescription to set
	 */
	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}

	/**
	 * @return the detailsDescription
	 */
	public String getDetailsDescription() {
		return detailsDescription;
	}

	/**
	 * @param detailsDescription the detailsDescription to set
	 */
	public void setDetailsDescription(String detailsDescription) {
		this.detailsDescription = detailsDescription;
	}

	/**
	 * @return the physicalShop
	 */
	public String getPhysicalShop() {
		return physicalShop;
	}

	/**
	 * @param physicalShop the physicalShop to set
	 */
	public void setPhysicalShop(String physicalShop) {
		this.physicalShop = physicalShop;
	}

	/**
	 * @return the physicalShopReferencing
	 */
	public Integer getPhysicalShopReferencing() {
		return physicalShopReferencing;
	}

	/**
	 * @param physicalShopReferencing the physicalShopReferencing to set
	 */
	public void setPhysicalShopReferencing(Integer physicalShopReferencing) {
		this.physicalShopReferencing = physicalShopReferencing;
	}

	/**
	 * @return the eCommerceSolution
	 */
	public String geteCommerceSolution() {
		return eCommerceSolution;
	}

	/**
	 * @param eCommerceSolution the eCommerceSolution to set
	 */
	public void seteCommerceSolution(String eCommerceSolution) {
		this.eCommerceSolution = eCommerceSolution;
	}

	/**
	 * @return the eCommerceSolutionRef
	 */
	public Integer geteCommerceSolutionRef() {
		return eCommerceSolutionRef;
	}

	/**
	 * @param eCommerceSolutionRef the eCommerceSolutionRef to set
	 */
	public void seteCommerceSolutionRef(Integer eCommerceSolutionRef) {
		this.eCommerceSolutionRef = eCommerceSolutionRef;
	}

	/**
	 * @return the customerServicePhone
	 */
	public String getCustomerServicePhone() {
		return customerServicePhone;
	}

	/**
	 * @param customerServicePhone the customerServicePhone to set
	 */
	public void setCustomerServicePhone(String customerServicePhone) {
		this.customerServicePhone = customerServicePhone;
	}

	/**
	 * @return the customerServiceFax
	 */
	public String getCustomerServiceFax() {
		return customerServiceFax;
	}

	/**
	 * @param customerServiceFax the customerServiceFax to set
	 */
	public void setCustomerServiceFax(String customerServiceFax) {
		this.customerServiceFax = customerServiceFax;
	}

	/**
	 * @return the customerServiceEmail
	 */
	public String getCustomerServiceEmail() {
		return customerServiceEmail;
	}

	/**
	 * @param customerServiceEmail the customerServiceEmail to set
	 */
	public void setCustomerServiceEmail(String customerServiceEmail) {
		this.customerServiceEmail = customerServiceEmail;
	}

	/**
	 * @return the languageId
	 */
	public Integer getLanguageId() {
		return languageId;
	}

	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	/**
	 * @return the customerServiceRate
	 */
	public String getCustomerServiceRate() {
		return customerServiceRate;
	}

	/**
	 * @param customerServiceRate the customerServiceRate to set
	 */
	public void setCustomerServiceRate(String customerServiceRate) {
		this.customerServiceRate = customerServiceRate;
	}

	/**
	 * @return the customerServiceSchedules
	 */
	public String getCustomerServiceSchedules() {
		return customerServiceSchedules;
	}

	/**
	 * @param customerServiceSchedules the customerServiceSchedules to set
	 */
	public void setCustomerServiceSchedules(String customerServiceSchedules) {
		this.customerServiceSchedules = customerServiceSchedules;
	}

	
	
	
	
	
	
	
}
