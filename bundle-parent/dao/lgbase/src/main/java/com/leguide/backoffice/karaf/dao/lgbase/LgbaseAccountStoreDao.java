package com.leguide.backoffice.karaf.dao.lgbase;


import com.leguide.backoffice.karaf.models.lgbase.account.LgbaseAccountStore;

import java.util.List;
import java.util.Optional;

public interface LgbaseAccountStoreDao {

    /**
     * Create a new account
     *
     * @param newAccountStore
     */
    void create(LgbaseAccountStore newAccountStore);

    LgbaseAccountStore update(LgbaseAccountStore lgbaseAccountStore);

    LgbaseAccountStore findById(Long storeUid);

    List<Long> getListIdShopsiteByAccountId(Long accountId);

    /**
     * The accountId corresponding to the given id shopsite
     *
     * @param idShopsite not null id shopsite
     * @return the account in tb_account_store linked to it, or null if none linked
     */
    Optional<Long> getByIdShopsite(Long idShopsite);


    /**
     * Return the list of LgbaseAccountStore by client
     * @param clientId
     * @return
     */
    List<LgbaseAccountStore> getListByClientId(String clientId);


}
