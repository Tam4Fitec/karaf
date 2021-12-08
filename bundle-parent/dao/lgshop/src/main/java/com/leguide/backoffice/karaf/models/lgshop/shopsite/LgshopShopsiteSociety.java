package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import com.leguide.backoffice.karaf.dao.lgshop.impl.LocaleLabelTuple;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@SqlResultSetMapping(name="SocietyCountriesResult", classes = {
        @ConstructorResult(targetClass = LocaleLabelTuple.class,
                columns = {@ColumnResult(name="lbl_locale"), @ColumnResult(name="lbl_label")})
})
@Entity
@Table(name="tb_shopsite_society")
@XmlRootElement(name = "LgshopShopsiteSociety")
public class LgshopShopsiteSociety implements Serializable {

	private static final long serialVersionUID = 7875406253324217882L;

	@Id
	@Column(name="id_shopsite")
	private Long shopsiteId;

	@Column(name="sso_compagny_name")
	private String compagnyName;

	@Column(name="sso_adress")
	private String adress;

	@Column(name="sso_adress2")
	private String adress2;

	@Column(name="sso_zipcode")
	private String zipCode;

	@Column(name="sso_city")
	private String city;

	@Column(name="sso_country")
	private Integer country;

	@Column(name="sso_company_phone")
	private String compagnyPhone;

	@Column(name="sso_company_type")
	private Long compagnyType;

	@Column(name="sso_other_company_type")
	private String otherCompagnyType;

	@Column(name="sso_Sirets_number")
	private String siretNumber;

	@Column(name="sso_rcs_number")
	private String rcsnumber;

	@Column(name="sso_Tva_Intra_number")
	private String tva;


	@Column(name="sso_create_date")
	private Date createDate;

	@Column(name="sso_update_date")
	private Date updateDate;

	public Long getShopsiteId() {
		return shopsiteId;
	}

	public void setShopsiteId(Long shopsiteId) {
		this.shopsiteId = shopsiteId;
	}

	public String getCompagnyName() {
		return compagnyName;
	}

	public void setCompagnyName(String compagnyName) {
		this.compagnyName = compagnyName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getAdress2() {
		return adress2;
	}

	public void setAdress2(String adress2) {
		this.adress2 = adress2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public String getCompagnyPhone() {
		return compagnyPhone;
	}

	public void setCompagnyPhone(String compagnyPhone) {
		this.compagnyPhone = compagnyPhone;
	}

	public Long getCompagnyType() {
		return compagnyType;
	}

	public void setCompagnyType(Long compagnyType) {
		this.compagnyType = compagnyType;
	}

	public String getOtherCompagnyType() {
		return otherCompagnyType;
	}

	public void setOtherCompagnyType(String otherCompagnyType) {
		this.otherCompagnyType = otherCompagnyType;
	}

	public String getSiretNumber() {
		return siretNumber;
	}

	public void setSiretNumber(String siretNumber) {
		this.siretNumber = siretNumber;
	}

	public String getRcsnumber() {
		return rcsnumber;
	}

	public void setRcsnumber(String rcsnumber) {
		this.rcsnumber = rcsnumber;
	}

	public String getTva() {
		return tva;
	}

	public void setTva(String tva) {
		this.tva = tva;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


}
