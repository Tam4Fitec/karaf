package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name="tb_shopsite_catalog")
@XmlRootElement(name = "LgshopShopsiteCatalog")
public class LgshopShopsiteCatalog implements Serializable {

	private static final long serialVersionUID = -6797421656937677209L;
	
	@Id
	@Column(name="id_shopsite")
	private Long shopsiteId;
	
	@Column(name="shc_mode")
	@Enumerated(EnumType.STRING)
	private LgshopShopsiteCatalogModeEnum mode;
	
	@Column(name="shc_catalog_url")
	private String catalogUrl;
	
	@Column(name="shc_catalog_ftp")
	private String catalogFtp;
	
	@Column(name="shc_ecommerce_id")
	private Integer ecommerceId;
	
	@Column(name="shc_ecommerce_other")
	private String ecommerceOther;
	

	public Long getShopsiteId() {
		return shopsiteId;
	}

	public void setShopsiteId(Long shopsiteId) {
		this.shopsiteId = shopsiteId;
	}

	public LgshopShopsiteCatalogModeEnum getMode() {
		return mode;
	}

	public void setMode(LgshopShopsiteCatalogModeEnum mode) {
		this.mode = mode;
	}

	public String getCatalogUrl() {
		return catalogUrl;
	}

	public void setCatalogUrl(String catalogUrl) {
		this.catalogUrl = catalogUrl;
	}

	public String getCatalogFtp() {
		return catalogFtp;
	}

	public void setCatalogFtp(String catalogFtp) {
		this.catalogFtp = catalogFtp;
	}

	public Integer getEcommerceId() {
		return ecommerceId;
	}

	public void setEcommerceId(Integer ecommerceId) {
		this.ecommerceId = ecommerceId;
	}

	public String getEcommerceOther() {
		return ecommerceOther;
	}

	public void setEcommerceOther(String ecommerceOther) {
		this.ecommerceOther = ecommerceOther;
	}

	
}
