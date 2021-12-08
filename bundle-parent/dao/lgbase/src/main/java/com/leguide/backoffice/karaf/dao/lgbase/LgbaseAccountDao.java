package com.leguide.backoffice.karaf.dao.lgbase;

import com.leguide.backoffice.karaf.models.lgbase.account.LgbaseAccount;

import java.util.List;
import java.util.Optional;


public interface LgbaseAccountDao {

    /**
     * Finds account by id
     * @param accountId
     * @return
     */
    LgbaseAccount findById(Long accountId);

	/**
	 * Create a new account
	 * @param newAccount
	 */
    void create(LgbaseAccount newAccount);

    /**
     * Updates account
     * @param accountToUpdate
     */
    void update(LgbaseAccount accountToUpdate);

    /**
     * Deletes account
     * @param accountToDelete
     */
    void delete(LgbaseAccount accountToDelete);


    /**
	 * Find clientId by accountId
	 * @param accountId
	 * @return
	 */
    Optional<String> findClientIdByAccountId(Long accountId);

    /**
     * find all shopsite ids of account
     * @param accountId
     * @return shopsite ids
     */
    List<Long> findShopsiteIdsOfAccount(Long accountId);
	/**
	 * Find accountId by clientId
	 * @param accountId
	 * @return
	 */
    Optional<Long> findAccountIdByClientId(String clientId);

	/**
	 * returns the account of a shopsite id
	 * @param shopsiteId
	 * @return
	 */
    Optional<LgbaseAccount> findAccountByShopsiteId(Long shopsiteId);

    /**
     * returns all accounts of a user
     * @param userId
     * @return accounts of the user
     */
    List<LgbaseAccount> findAccountsByUserId(Long userId);

    /**
	 * Returns the client id of a shopsite
	 * @param shopsiteId
	 * @return client id
	 */
    Optional<String> findClientIdByShopsiteId(Long shopsiteId);


}
