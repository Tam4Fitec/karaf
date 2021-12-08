package com.leguide.backoffice.karaf.webservices.wsclient.models;

public class ContactForm {

    private Long shopsiteId;

    private String contactEmail;

    private Integer demandType;

    private String body;

    public Long getShopsiteId() {
        return shopsiteId;
    }

    public void setShopsiteId(Long shopsiteId) {
        this.shopsiteId = shopsiteId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Integer getDemandType() {
        return demandType;
    }

    public void setDemandType(Integer demandType) {
        this.demandType = demandType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
