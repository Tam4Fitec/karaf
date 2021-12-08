package com.leguide.backoffice.karaf.business.models.pojo;

public class Account extends Model {

    private static final long serialVersionUID = -615357473296005966L;

    private Long id;
    private Long parentAccountId;
    private String name;
    private String streetAddress;
    private String complementAddress;
    private String zipCode;
    private String city;
    private String country;
    private String phoneCompany;
    private AccountStateEnum state;
    private String companyType;
    private String siretNumber;
    private String vatNumber;
    private boolean agency;
    private Long selfcareAccountId;
    private String codeClient;
    private String libelleClient;

    public Long getId() {
        return id;
    }

    public void setId(Long accountId) {
        this.id = accountId;
    }

    public Long getParentAccountId() {
        return parentAccountId;
    }

    public void setParentAccountId(Long parentAccountId) {
        this.parentAccountId = parentAccountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getComplementAddress() {
        return complementAddress;
    }

    public void setComplementAddress(String complementAddress) {
        this.complementAddress = complementAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(String phoneCompany) {
        this.phoneCompany = phoneCompany;
    }

    public AccountStateEnum getState() {
        return state;
    }

    public void setState(AccountStateEnum state) {
        this.state = state;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getSiretNumber() {
        return siretNumber;
    }

    public void setSiretNumber(String siretNumber) {
        this.siretNumber = siretNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public boolean isAgency() {
        return agency;
    }

    public void setAgency(boolean agency) {
        this.agency = agency;
    }

    public Long getSelfcareAccountId() {
        return selfcareAccountId;
    }

    public void setSelfcareAccountId(Long selfcareAccountId) {
        this.selfcareAccountId = selfcareAccountId;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public String getLibelleClient() {
        return libelleClient;
    }

    public void setLibelleClient(String libelleClient) {
        this.libelleClient = libelleClient;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((id == null) ? 0 : id.hashCode());
        result = prime * result + (agency ? 1231 : 1237);
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result
                + ((codeClient == null) ? 0 : codeClient.hashCode());
        result = prime * result
                + ((companyType == null) ? 0 : companyType.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((parentAccountId == null) ? 0 : parentAccountId.hashCode());
        result = prime * result
                + ((phoneCompany == null) ? 0 : phoneCompany.hashCode());
        result = prime
                * result
                + ((selfcareAccountId == null) ? 0 : selfcareAccountId
                .hashCode());
        result = prime * result
                + ((siretNumber == null) ? 0 : siretNumber.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result
                + ((streetAddress == null) ? 0 : streetAddress.hashCode());
        result = prime * result
                + ((vatNumber == null) ? 0 : vatNumber.hashCode());
        result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (agency != other.agency)
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (codeClient == null) {
            if (other.codeClient != null)
                return false;
        } else if (!codeClient.equals(other.codeClient))
            return false;
        if (companyType == null) {
            if (other.companyType != null)
                return false;
        } else if (!companyType.equals(other.companyType))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (parentAccountId == null) {
            if (other.parentAccountId != null)
                return false;
        } else if (!parentAccountId.equals(other.parentAccountId))
            return false;
        if (phoneCompany == null) {
            if (other.phoneCompany != null)
                return false;
        } else if (!phoneCompany.equals(other.phoneCompany))
            return false;
        if (selfcareAccountId == null) {
            if (other.selfcareAccountId != null)
                return false;
        } else if (!selfcareAccountId.equals(other.selfcareAccountId))
            return false;
        if (siretNumber == null) {
            if (other.siretNumber != null)
                return false;
        } else if (!siretNumber.equals(other.siretNumber))
            return false;
        if (state != other.state)
            return false;
        if (streetAddress == null) {
            if (other.streetAddress != null)
                return false;
        } else if (!streetAddress.equals(other.streetAddress))
            return false;
        if (vatNumber == null) {
            if (other.vatNumber != null)
                return false;
        } else if (!vatNumber.equals(other.vatNumber))
            return false;
        if (zipCode == null) {
            if (other.zipCode != null)
                return false;
        } else if (!zipCode.equals(other.zipCode))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Account [id=" + id + ", parentAccountId=" + parentAccountId
                + ", name=" + name + ", streetAddress=" + streetAddress
                + ", zipCode=" + zipCode + ", city=" + city + ", country="
                + country + ", phoneCompany=" + phoneCompany + ", state="
                + state + ", companyType=" + companyType + ", siretNumber="
                + siretNumber + ", vatNumber=" + vatNumber + ", agency="
                + agency + ", selfcareAccountId=" + selfcareAccountId
                + ", codeClient=" + codeClient + ", libelleClient="
                + libelleClient + "]";
    }

}
