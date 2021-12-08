package com.leguide.backoffice.karaf.dao.lgbase;

import com.leguide.backoffice.karaf.models.lgbase.users.Users;

import java.util.List;
import java.util.Optional;

public interface UsersDao {

	/**
	 * Create a new users
	 * @param newUsers
	 */
	void create(Users user);

	/**
	 * Update a  user
	 * @param user
	 */
	Users update(Users user);

	Users findById(Long Id);

    /**
     * Find by email and password, used for authentication
     * @param email email
     * @param password password
     * @return user, or null
     */
    Optional<Users> findByEmailAndPassword(String email, String password);

	/**
	 *
	 * @param id
	 * @return
	 */
	void deleteById(Long id);
	//TODO get by email

	/**
	 * Find a user by its email. There is a unique constraint on the email in db
	 * @param email not null
	 * @return a non null User
	 */
    Optional<Users> findByEmail(String email);

    /**
     * Used in Merchant record form (fiche marchand)
     *
     * @param shopsiteId shopsiteId
     * @return User
     */
    Users findFirstByShopsite(Long shopsiteId);

    /**
     * Return, for one shopsiteId, the list of user_id :
     * <li> having a role
     * <li> having a valid email
     *
     * @param shopsiteId shopsiteId
     * @return List of user id
     */
    List<Long> findUsersByShopsite(Long shopsiteId);

    /**
     * Find all contacts for shopsite and roles
     * @param shopsiteId shopsiteId
     * @param roles roles
     * @return all contacts
     */
    List<Users> findAllByShopsiteAndRoles(Long shopsiteId, List<Integer> roles);
}
