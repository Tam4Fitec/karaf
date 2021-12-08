package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import java.util.List;


public class LgshopPaymentOptions {
	private List<String> paymentCards;
	private List<String> paymentSolutions;
	private List<String> otherPaymentMethods;

	public LgshopPaymentOptions() {}
	
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