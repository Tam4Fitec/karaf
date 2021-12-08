package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="rf_origin")
public class RefOrigin implements Serializable {

	private static final long serialVersionUID = 4910861094183732572L;
	
	@Id
	@Column(name="id_origin")
	private Long originId;

	@Column(name="rfo_name")
	private String name;
	
	@Column(name="rfo_prefix_export_file_name")
	private String prefixExportFileName;


	
	public Long getOriginId() {
		return originId;
	}

	public void setOriginId(Long originId) {
		this.originId = originId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefixExportFileName() {
		return prefixExportFileName;
	}

	public void setPrefixExportFileName(String prefixExportFileName) {
		this.prefixExportFileName = prefixExportFileName;
	}

}
