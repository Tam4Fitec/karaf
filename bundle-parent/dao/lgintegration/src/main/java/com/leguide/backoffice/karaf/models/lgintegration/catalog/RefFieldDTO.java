package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name="rf_field",schema="lgintegration")
public class RefFieldDTO implements Serializable {

	private static final long serialVersionUID = -8593017197734582906L;

	@Id
	@Column(name="id_field")
	private Long id;
	
	@Column(name="fld_name")
	private String name;

	@Column(name="fld_label")
	private String label;
	
	@Column(name="fld_description")
	private String description;

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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
