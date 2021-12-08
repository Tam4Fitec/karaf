package com.leguide.backoffice.karaf.bundle.business.contact.routes.pojo;

import java.io.Serializable;

import com.leguide.backoffice.karaf.business.models.pojo.contact.Contact;

public final class SmartFocusUpdatePOJO implements Serializable {

    private static final long serialVersionUID = 4075830351323667486L;
    private Long contactId;
    private Integer civility;
    private String firstName;
    private String lastName;
    private String email;
    private Long accountId;
    private String country;
    private String optOutToken;
    private String optOutTokenPartner;
    private Integer optInLG;
    private Integer optInPartner;

    public SmartFocusUpdatePOJO(Contact contact) {
        contactId = contact.getContactId();
        civility = contact.getCivility() != null ?  contact.getCivility().getId() : null;
        firstName = contact.getFirstName();
        lastName = contact.getLastName();
        email = contact.getEmail();
        accountId = contact.getSelfcareAccountId();
        country = contact.getCountry();
        optOutToken = contact.getOptOutToken();
        optOutTokenPartner = contact.getOptOutTokenPartner();
        optInLG = contact.getIsOptInLG() != null ? (contact.getIsOptInLG().equalsIgnoreCase("y") ? 1 : 0) : null;
        optInPartner = contact.getIsOptInPartner() != null ? (contact.getIsOptInPartner().equalsIgnoreCase("y") ? 1 : 0) : null;
    }

    public Long getContactId() {
        return contactId;
    }

    public Integer getCivility() {
        return civility;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getCountry() {
        return country;
    }

    public String getOptOutToken() {
        return optOutToken;
    }

    public String getOptOutTokenPartner() {
        return optOutTokenPartner;
    }

    public Integer getOptInLG() {
        return optInLG;
    }

    public Integer getOptInPartner() {
        return optInPartner;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
        result = prime * result + ((civility == null) ? 0 : civility.hashCode());
        result = prime * result + ((contactId == null) ? 0 : contactId.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((optInLG == null) ? 0 : optInLG.hashCode());
        result = prime * result + ((optInPartner == null) ? 0 : optInPartner.hashCode());
        result = prime * result + ((optOutToken == null) ? 0 : optOutToken.hashCode());
        result = prime * result + ((optOutTokenPartner == null) ? 0 : optOutTokenPartner.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SmartFocusUpdatePOJO other = (SmartFocusUpdatePOJO) obj;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;
        if (civility == null) {
            if (other.civility != null)
                return false;
        } else if (!civility.equals(other.civility))
            return false;
        if (contactId == null) {
            if (other.contactId != null)
                return false;
        } else if (!contactId.equals(other.contactId))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (optInLG == null) {
            if (other.optInLG != null)
                return false;
        } else if (!optInLG.equals(other.optInLG))
            return false;
        if (optInPartner == null) {
            if (other.optInPartner != null)
                return false;
        } else if (!optInPartner.equals(other.optInPartner))
            return false;
        if (optOutToken == null) {
            if (other.optOutToken != null)
                return false;
        } else if (!optOutToken.equals(other.optOutToken))
            return false;
        if (optOutTokenPartner == null) {
            if (other.optOutTokenPartner != null)
                return false;
        } else if (!optOutTokenPartner.equals(other.optOutTokenPartner))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SmartFocusUpdatePOJO [contactId=" + contactId + ", civility=" + civility + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email + ", accountId=" + accountId + ", country=" + country
                + ", optOutToken=" + optOutToken + ", optOutTokenPartner=" + optOutTokenPartner + ", optInLG="
                + optInLG + ", optInPartner=" + optInPartner + "]";
    }

}
