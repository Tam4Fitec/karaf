package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="tb_catalog_schedule")
public class CatalogSchedule implements Serializable {

	private static final long serialVersionUID = 8753777183449543376L;
	
	@Id
	@Column(name="id_catalog")
	private Long catalogId;
	
	@Column(name="sch_expression")
	private String expression;
	
	@Column(name="sch_active")
	private Boolean active;
	
	@Column(name="with_expression")
	private Boolean withExpression;
	
	public Long getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getWithExpression() {
		return withExpression;
	}

	public void setWithExpression(Boolean withExpression) {
		this.withExpression = withExpression;
	}
	

}
