package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FieldNormalizationPrimaryKey  implements Serializable {
	
	private static final long serialVersionUID = 3370782659057810307L;

	@Column(name="id_field")
	private Integer internalFieldIndex;

	@Column(name="id_catalog")
	private Long catalogId;

	public Integer getInternalFieldIndex() {
		return internalFieldIndex;
	}

	public void setInternalFieldIndex(Integer internalFieldIndex) {
		this.internalFieldIndex = internalFieldIndex;
	}

	public Long getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}
}
