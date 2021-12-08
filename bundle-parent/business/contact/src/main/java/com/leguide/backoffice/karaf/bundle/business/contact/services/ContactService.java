package com.leguide.backoffice.karaf.bundle.business.contact.services;

import com.leguide.backoffice.karaf.business.models.pojo.contact.Contact;

import org.apache.camel.Exchange;

public interface ContactService {

	public Long createContact(Contact contact);

	public void createContactFromJms(Exchange exchange);

	public void updateContactFromJms(Exchange exchange);

	public void update(Contact contact);

	public void deleteContactFromJms(Exchange exchange);

	public void delete(Contact contact);

}
