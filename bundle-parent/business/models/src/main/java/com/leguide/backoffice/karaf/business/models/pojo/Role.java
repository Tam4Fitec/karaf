package com.leguide.backoffice.karaf.business.models.pojo;

public class Role {

    private Long contactId;
    private Long shopSiteId;
    private Long accountId;
    private String roleType;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getShopSiteId() {
        return shopSiteId;
    }

    public void setShopSiteId(Long shopSiteId) {
        this.shopSiteId = shopSiteId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Role [contactId=" + contactId + ", shopSiteId=" + shopSiteId
                + ", accountId=" + accountId + ", roleType=" + roleType + "]";
    }
}