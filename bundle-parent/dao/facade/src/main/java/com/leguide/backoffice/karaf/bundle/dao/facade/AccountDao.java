package com.leguide.backoffice.karaf.bundle.dao.facade;

import com.leguide.backoffice.karaf.business.models.pojo.Account;
import com.leguide.backoffice.karaf.business.models.pojo.MergeAccount;

import java.util.List;
import java.util.Set;

public interface AccountDao {

	/**
	 * Find an account by the id
	 * @param accountId the account id to find
	 * @return the account
	 */
    Account findById(Long accountId);

	Long create(Account account);


    /**
     * Finds clientId by accountId
     * @param accountId
     * @return
     */
    String findClientIdByAccountId(Long accountId);

    /**
     * Updates account
     * @param accountToUpdate
     */
    void updateAccount(Account accountToUpdate);

    /**
     * Deletes account
     * @param accountToDelete
     */
    void deleteAccount(Account accountToDelete);

    /**
     * Attachs store to account if necessary
     * @param account
     * @param shopSiteId
     */
    void attachStoreToAccountIfNecessary(Account account, Long shopSiteId);

    /**
     * Attachs contact to account if necessary
     * @param newAccount
     * @param oldAccounts
     * @param userId
     */
    void attachContactToAccountIfNecessary(Account newAccount, Set<Account> oldAccounts, Long userId);


    /**
     * Retrieve All account client to Merge.
     * @return
     */
    List<MergeAccount> getlistAccountClientToMerge();


    /**
     *
     * @param codeClient
     * @return
     */
    MergeAccount getMergeAccountForClient(String codeClient);

    /**
     *
     * @param shopsiteId
     * @param accountId
     */
    void createAccountStore(Long shopsiteId , Long accountId);

}
