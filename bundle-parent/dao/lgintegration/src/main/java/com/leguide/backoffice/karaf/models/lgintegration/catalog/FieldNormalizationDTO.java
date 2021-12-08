package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table( name="tb_field_normalization")
public class FieldNormalizationDTO implements Serializable {

	private static final long serialVersionUID = -6162072968192779260L;
	
	@EmbeddedId
	private FieldNormalizationPrimaryKey normalizationPrimaryKey;
	
	@Column(name="fnz_normalized")
	private String normalized;
	
	@Column(name="fnz_specific")
	private String specific;
	
	@Column(name="fnz_ratio")
	private String ratio;

	public FieldNormalizationPrimaryKey getNormalizationPrimaryKey() {
		return normalizationPrimaryKey;
	}

	public void setNormalizationPrimaryKey(
			FieldNormalizationPrimaryKey normalizationPrimaryKey) {
		this.normalizationPrimaryKey = normalizationPrimaryKey;
	}

	public String getNormalized() {
		return normalized;
	}

	public void setNormalized(String normalized) {
		this.normalized = normalized;
	}

	public String getSpecific() {
		return specific;
	}

	public void setSpecific(String specific) {
		this.specific = specific;
	}

	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	

}
