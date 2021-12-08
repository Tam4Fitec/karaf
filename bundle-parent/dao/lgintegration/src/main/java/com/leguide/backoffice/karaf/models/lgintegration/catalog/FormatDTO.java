package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class FormatDTO implements Serializable {

	private static final long serialVersionUID = -6388337718409532858L;

	@Id
	@Column(name="id_format")
	private Long id;
	
	@Column(name="frm_name")
	private String name;
	
	@Column(name="frm_country")
	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
