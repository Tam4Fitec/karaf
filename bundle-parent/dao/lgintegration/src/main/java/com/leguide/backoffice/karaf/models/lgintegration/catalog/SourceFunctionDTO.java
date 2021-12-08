package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="tb_source_function")
public class SourceFunctionDTO implements Serializable {

	private static final long serialVersionUID = -887943613972298298L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_source_function")
	private Long id;
	
	@Column(name="sfn_param_1")
	private String parameters1;
	
	@Column(name="sfn_param_2")
	private String parameters2;
	
	@Column(name="sfn_order")
	private Integer order;
	
	@Column(name="sfn_active")
	private String active;
	
	@Column(name="id_source")
	private Long sourceId;
	
	@Column(name="id_function")
	private Long functionId;
	
	@Column(name="id_field")
	private Long fieldId;
	
	@Column(name="id_merchant_field")
	private Long merchantFieldId;
	
	@Column(name="sfn_condition_active")
	private String conditionActive;
	
	@Column(name="sfn_condition_id_field_1")
	private Long conditionField1Id;
	
	@Column(name="sfn_condition_id_field_2")
	private Long conditionField2Id;
	
	@Column(name="sfn_condition_param_2")
	private String conditionParameter2Id;
	
	@Column(name="id_condition_operator")
	private Long conditionOperatorId;
	
	@Column(name="sfn_condition_field_type")
	private String conditionFieldType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParameters1() {
		return parameters1;
	}

	public void setParameters1(String parameters1) {
		this.parameters1 = parameters1;
	}

	public String getParameters2() {
		return parameters2;
	}

	public void setParameters2(String parameters2) {
		this.parameters2 = parameters2;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public Long getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

	public Long getMerchantFieldId() {
		return merchantFieldId;
	}

	public void setMerchantFieldId(Long merchantFieldId) {
		this.merchantFieldId = merchantFieldId;
	}

	public String getConditionActive() {
		return conditionActive;
	}

	public void setConditionActive(String conditionActive) {
		this.conditionActive = conditionActive;
	}

	public Long getConditionField1Id() {
		return conditionField1Id;
	}

	public void setConditionField1Id(Long conditionField1Id) {
		this.conditionField1Id = conditionField1Id;
	}

	public Long getConditionField2Id() {
		return conditionField2Id;
	}

	public void setConditionField2Id(Long conditionField2Id) {
		this.conditionField2Id = conditionField2Id;
	}

	public String getConditionParameter2Id() {
		return conditionParameter2Id;
	}

	public void setConditionParameter2Id(String conditionParameter2Id) {
		this.conditionParameter2Id = conditionParameter2Id;
	}

	public Long getConditionOperatorId() {
		return conditionOperatorId;
	}

	public void setConditionOperatorId(Long conditionOperatorId) {
		this.conditionOperatorId = conditionOperatorId;
	}

	public String getConditionFieldType() {
		return conditionFieldType;
	}

	public void setConditionFieldType(String conditionFieldType) {
		this.conditionFieldType = conditionFieldType;
	}
	
}
