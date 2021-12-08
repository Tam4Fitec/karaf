package com.leguide.backoffice.karaf.business.models.pojo.contact;

import com.leguide.backoffice.karaf.business.models.pojo.Model;



public class Contact extends Model {

    private static final long serialVersionUID = -5723312391213578187L;

    private Long contactId;
    private ContactCivility civility;
    private String firstName;
    private String lastName;
    private ContactService service;
    private ContactFunction function;
    private String email;
    private String phone;
    private String mobilePhone;
    private String fax;
    private String accountId;
    private Long selfcareAccountId;
    private String password;
    private Integer languageId;
    private String  country;
    private String optOutToken;
    private String optOutTokenPartner;
    private String isOptInLG;
    private String isOptInPartner;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public ContactCivility getCivility() {
        return civility;
    }

    public void setCivility(ContactCivility title) {
        this.civility = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactService getService() {
        return service;
    }

    public void setService(ContactService service) {
        this.service = service;
    }

    public ContactFunction getFunction() {
		return function;
	}

    public void setFunction(ContactFunction function) {
		this.function = function;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the selfcareAccountId
	 */
	public Long getSelfcareAccountId() {
		return selfcareAccountId;
	}

	/**
	 * @param selfcareAccountId the selfcareAccountId to set
	 */
	public void setSelfcareAccountId(Long selfcareAccountId) {
		this.selfcareAccountId = selfcareAccountId;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
    
    public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

    public String getOptOutToken() {
        return optOutToken;
    }

    public void setOptOutToken(String optOutToken) {
        this.optOutToken = optOutToken;
    }

    public String getOptOutTokenPartner() {
        return optOutTokenPartner;
    }

    public void setOptOutTokenPartner(String optOutTokenPartner) {
        this.optOutTokenPartner = optOutTokenPartner;
    }

    public String getIsOptInLG() {
        return isOptInLG;
    }

    public void setIsOptInLG(String isOptInLG) {
        this.isOptInLG = isOptInLG;
    }

    public String getIsOptInPartner() {
        return isOptInPartner;
    }

    public void setIsOptInPartner(String isOptinPartner) {
        this.isOptInPartner = isOptinPartner;
    }

    @Override
    public String toString() {
        return "Contact [contactId=" + contactId + ", civility=" + civility + ", firstName=" + firstName
                + ", lastName=" + lastName + ", service=" + service + ", function=" + function + ", email=" + email
                + ", phone=" + phone + ", mobilePhone=" + mobilePhone + ", fax=" + fax + ", accountId=" + accountId
                + ", selfcareAccountId=" + selfcareAccountId + ", password=" + password + ", languageId=" + languageId
                + ", country=" + country + ", optOutToken=" + optOutToken + ", optOutTokenPartner="
                + optOutTokenPartner + ", isOptInLG=" + isOptInLG + ", isOptInPartner=" + isOptInPartner + "]";
    }

}
