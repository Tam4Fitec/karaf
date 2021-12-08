package com.leguide.backoffice.karaf.services.email.models;

import javax.mail.Message;

public class EmailRecipient {

    private Message.RecipientType recipientType;

    private String address;

    public EmailRecipient(Message.RecipientType recipientType, String address) {
        this.recipientType = recipientType;
        this.address = address;
    }

    public Message.RecipientType getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(Message.RecipientType recipientType) {
        this.recipientType = recipientType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
