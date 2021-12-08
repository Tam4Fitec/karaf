package com.leguide.backoffice.karaf.models.lgintegration.custom;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class FeedFunctionDTO implements Serializable {

	private static final long serialVersionUID = -7934727318780848653L;
	
	
	@Id
	@Column(name="id_source_function")
	private Long sourceFunctionId;
	
	@Column(name="id_source")
	private Long sourceId;
	
	@Column(name="sfn_order")
	private int order;
	
	@Column(name="sfn_condition_active")
	private boolean conditionActive;
	
	@Column(name="leftCondition")
	private String leftCondition;
	
	@Column(name="sfn_condition_field_type")
	private boolean conditionFieldType;
	
	@Column(name="rightConditionField")
	private String rightConditionField;
	
	@Column(name="sfn_condition_param_2")
	private String rightConditionText;
	
	@Column(name="conditionOperator")
	private String conditionOperator;
	
	
	@Column(name="functionName")
	private String functionName;
	
	@Column(name="sfn_param_1")
	private String param1;
	
	@Column(name="sfn_param_2")
	private String param2;
	
	@Column(name="field")
	private String field;

	
	
	
	public Long getSourceFunctionId() {
		return sourceFunctionId;
	}

	public void setSourceFunctionId(Long sourceFunctionId) {
		this.sourceFunctionId = sourceFunctionId;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public boolean isConditionActive() {
		return conditionActive;
	}

	public void setConditionActive(boolean conditionActive) {
		this.conditionActive = conditionActive;
	}

	public String getLeftCondition() {
		return leftCondition;
	}

	public void setLeftCondition(String leftCondition) {
		this.leftCondition = leftCondition;
	}

	public boolean isConditionFieldType() {
		return conditionFieldType;
	}

	public void setConditionFieldType(boolean conditionFieldType) {
		this.conditionFieldType = conditionFieldType;
	}

	public String getRightConditionField() {
		return rightConditionField;
	}

	public void setRightConditionField(String rightConditionField) {
		this.rightConditionField = rightConditionField;
	}

	public String getRightConditionText() {
		return rightConditionText;
	}

	public void setRightConditionText(String rightConditionText) {
		this.rightConditionText = rightConditionText;
	}

	public String getConditionOperator() {
		return conditionOperator;
	}

	public void setConditionOperator(String conditionOperator) {
		this.conditionOperator = conditionOperator;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	
	
	
	
	
	
	
}
