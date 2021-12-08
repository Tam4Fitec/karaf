package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FieldMappingkey implements Serializable {

	private static final long serialVersionUID = 1210005710763121594L;

	@Column(name="id_field")
	private Integer internalFieldIndex;
	
	@Column(name="id_source")
	private Long sourceId;

	
	public Integer getInternalFieldIndex() {
		return internalFieldIndex;
	}

	public void setInternalFieldIndex(Integer internalFieldIndex) {
		this.internalFieldIndex = internalFieldIndex;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	
	
	
	
}
