package com.leguide.backoffice.karaf.dao.lgbase;

import com.leguide.backoffice.karaf.models.lgbase.users.UsersAccount;

import java.util.List;

public interface UsersAccountDao {

    /**
     * Finds by id
     * @param accountId
     * @param userId
     * @return
     */
    UsersAccount findById(Long accountId, Long userId);

    /**
     * Create a new usersAccount
     *
     * @param newUsersAccount
     */
    void create(UsersAccount newUsersAccount);

    /**
     * @param id
     * @return
     */
    void deleteByUserId(Long id);

    /**
     * Updates accountId
     * @param newAccountId
     * @param oldAccountId
     * @param userId
     */
    void updateAccountId(Long newAccountId, Long oldAccountId, Long userId);

    /**
     * Delete one row in tb_users_account, correponding to (userId, accountId)
     *
     * @param userId    not null
     * @param accountId not null
     */
    void deleteByPk(Long userId, Long accountId);

    boolean isUserLinkedToSeveralAccounts(Long userId);


    List<UsersAccount> findByClientId(String clientId);

    /**
     * get all account ids of user
     * @param userId
     * @return accounts
     */
	List<UsersAccount> getAccountsOfUser(Long userId);

}
