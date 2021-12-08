package com.leguide.backoffice.karaf.bundle.business.contact.services.impl;

import com.leguide.backoffice.karaf.bundle.business.contact.services.ContactService;
import com.leguide.backoffice.karaf.bundle.dao.facade.ContactDao;
import com.leguide.backoffice.karaf.business.models.pojo.contact.Contact;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContactServiceImpl implements ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

    private ContactDao contactDao;

    @Override
    public Long createContact(Contact contact) {
        return contactDao.create(contact);
    }

    @Override
    public void createContactFromJms(Exchange exchange) {
        Contact contact = (Contact) exchange.getIn().getBody();
        logger.info("Debut Creation du  contact  " + contact.getLastName() + " - " + contact.getFirstName());
        Long contactId = createContact(contact);
        contact.setContactId(contactId);
        logger.info("Fin Creation du  contact " + contact.getLastName() + " : contactId = " + contactId);
        exchange.getIn().setBody(contact);
    }


    @Override
    public void update(Contact contact) {
        contactDao.update(contact);
    }

    @Override
    public void updateContactFromJms(Exchange exchange) {
        Contact contact = (Contact) exchange.getIn().getBody();
        update(contact);
    }

    @Override
    public void deleteContactFromJms(Exchange exchange) {
        Contact contact = (Contact) exchange.getIn().getBody();
        logger.info("Debut Delete du  contact  " + contact.getLastName() + " - " + contact.getFirstName());
        delete(contact);
        logger.info("Fin Delete du  contact : contactId = " + contact.getContactId());
    }

    @Override
    public void delete(Contact contact) {
        if (contact.getContactId() != null) {
            contactDao.delete(contact);
        }
    }

    /**
     * @return the contactDao
     */
    public ContactDao getContactDao() {
        return contactDao;
    }

    /**
     * @param contactDao the contactDao to set
     */
    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }


}
