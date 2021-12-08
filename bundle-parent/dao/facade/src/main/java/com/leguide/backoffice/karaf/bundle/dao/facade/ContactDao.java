package com.leguide.backoffice.karaf.bundle.dao.facade;

import com.leguide.backoffice.karaf.business.models.pojo.contact.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDao {

	Contact findById(Long contactId);

    Optional<Contact> findByEmail(String email);

    /**
     * Find by email and password, used for authentication
     * @param email email
     * @param password password
     * @return contact, or null
     */
    Optional<Contact> findByEmailAndPassword(String email, String password);

    /**
     * Used in Merchant record form (fiche marchand)
     *
     * @param shopsiteId shopsiteId
     * @return User
     */
    Contact findFirstByShopsite(Long shopsiteId);

    /**
     * Find all contacts for shopsite and roles
     * @param shopsiteId shopsiteId
     * @param roles roles
     * @return all contacts
     */
    List<Contact> findAllByShopsiteAndRoles(Long shopsiteId, List<Integer> roles);

	Long create(Contact contact);

	void update(Contact contact);

	void delete(Contact contact);


}
