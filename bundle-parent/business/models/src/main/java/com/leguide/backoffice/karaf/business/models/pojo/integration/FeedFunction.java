package com.leguide.backoffice.karaf.business.models.pojo.integration;

import java.io.Serializable;

public class FeedFunction implements Serializable  {

	private static final long serialVersionUID = -7989353282807494111L;

	
	private int order;
	private boolean conditionActive;
	private String leftCondition;
	private String conditionOperator;
	private boolean rightConditionFieldType;
	private String rightCondition;
	private String function;
	
	private boolean param1FieldType;
	private String param1;
	private String param2;
	private String field;
	
	
	
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
	public String getConditionOperator() {
		return conditionOperator;
	}
	public void setConditionOperator(String conditionOperator) {
		this.conditionOperator = conditionOperator;
	}

	public String getRightCondition() {
		return rightCondition;
	}
	public void setRightCondition(String rightCondition) {
		this.rightCondition = rightCondition;
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

	public boolean isRightConditionFieldType() {
		return rightConditionFieldType;
	}
	public void setRightConditionFieldType(boolean rightConditionFieldType) {
		this.rightConditionFieldType = rightConditionFieldType;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public boolean isParam1FieldType() {
		return param1FieldType;
	}
	public void setParam1FieldType(boolean param1FieldType) {
		this.param1FieldType = param1FieldType;
	}

	
}
