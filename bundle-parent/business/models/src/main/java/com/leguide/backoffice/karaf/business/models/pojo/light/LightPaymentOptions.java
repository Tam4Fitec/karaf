package com.leguide.backoffice.karaf.business.models.pojo.light;

import java.io.Serializable;
import java.util.List;

public class LightPaymentOptions implements Serializable  {
	
	
	private static final long serialVersionUID = 3218054477086319975L;
	
	private List<String> paymentCards;
	private List<String> paymentSolutions;
	private List<String> otherPaymentMethods;

	public LightPaymentOptions() {}
	
	public List<String> getPaymentCards() {
		return paymentCards;
	}

	public void setPaymentCards(List<String> paymentCards) {
		this.paymentCards = paymentCards;
	}

	public List<String> getPaymentSolutions() {
		return paymentSolutions;
	}

	public void setPaymentSolutions(List<String> paymentSolutions) {
		this.paymentSolutions = paymentSolutions;
	}

	public List<String> getOtherPaymentMethods() {
		return otherPaymentMethods;
	}

	public void setOtherPaymentMethods(List<String> otherPaymentMethods) {
		this.otherPaymentMethods = otherPaymentMethods;
	}
}
