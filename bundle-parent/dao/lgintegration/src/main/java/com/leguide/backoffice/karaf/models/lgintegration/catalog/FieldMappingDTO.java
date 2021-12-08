package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table( name="tb_field_mapping")
public class FieldMappingDTO implements Serializable {
	

	private static final long serialVersionUID = -5559798901144675530L;

	@EmbeddedId
	private FieldMappingkey fieldMappingkey;
	
	@Column(name="fmp_map_value")
	private String mappingvalue;
	
	@Transient
	private String fieldInternalLabel;
	
	@Column(name="id_mapping_function")
	private Long functionId;
	
	public FieldMappingkey getFieldMappingkey() {
		return fieldMappingkey;
	}

	public void setFieldMappingkey(FieldMappingkey fieldMappingkey) {
		this.fieldMappingkey = fieldMappingkey;
	}

	public String getMappingvalue() {
		return mappingvalue;
	}

	public void setMappingvalue(String mappingvalue) {
		this.mappingvalue = mappingvalue;
	}

	public Long getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}

	public String getFieldInternalLabel() {
		//TODO:A modifier mettre une dépendance
		if (this.getFieldMappingkey() != null || this.getFieldMappingkey().getInternalFieldIndex() != null) {
			fieldInternalLabel = "label " + this.getFieldMappingkey().getInternalFieldIndex();
		}else{
			fieldInternalLabel = "label x";
		}
		return fieldInternalLabel;
	}

	public void setFieldInternalLabel(String fieldInternalLabel) {
		this.fieldInternalLabel = fieldInternalLabel;
	}
}
