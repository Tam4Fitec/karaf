package com.leguide.backoffice.karaf.webservices.wsclient.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Balance {

    private Double balance;
    

	/**
	 * @param balance
	 */
	public Balance(Double balance) {
		super();
		this.balance = balance;
	}

	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
    
    
    
}
