package com.leguide.backoffice.karaf.webservices.wsclient.models;

public class Subscription {

    private String contactEmail;

    private String period;

    public Subscription() {
    }

    public Subscription(String contactEmail, String period) {
        this.contactEmail = contactEmail;
        this.period = period;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

}
