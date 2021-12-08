package com.leguide.backoffice.karaf.models.lgbase.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lg_client_info")
public class LgBaseClientInfos {
	@Id
	@Column(name = "client_id")
	private String clientId;
	@Column(name = "heading")
	private String heading;
	@Column(name = "address1")
	private String address1;
	@Column(name = "address2")
	private String address2;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;
	@Column(name = "zip_code")
	private String zipCode;
	@Column(name = "intra_community_id")
	private String intraCommunityId;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getIntraCommunityId() {
		return intraCommunityId;
	}
	public void setIntraCommunityId(String intraCommunityId) {
		this.intraCommunityId = intraCommunityId;
	}
	
}
