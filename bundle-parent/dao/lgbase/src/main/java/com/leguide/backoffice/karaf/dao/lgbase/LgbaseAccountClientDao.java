package com.leguide.backoffice.karaf.dao.lgbase;


import com.leguide.backoffice.karaf.models.lgbase.account.LgbaseAccountClient;

import java.util.List;

public interface LgbaseAccountClientDao {

    LgbaseAccountClient findById(Long accountId);

    LgbaseAccountClient findMasterByClientId(String clientId);

    /**
     * Deletes accountClient
     * @param accountToDelete
     */
    void delete(LgbaseAccountClient accountToDelete);

    /**
     * find all clients with multiple accounts
     * @return
     */
    List<String> findClientWithMultipleAccount();



}
