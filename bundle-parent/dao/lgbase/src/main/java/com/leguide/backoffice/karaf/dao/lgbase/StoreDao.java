package com.leguide.backoffice.karaf.dao.lgbase;

import com.leguide.backoffice.karaf.models.lgbase.merchant.Store;

public interface StoreDao {

    /**
     * @param idShopsite idShopsite
     * @return storeId
     */
    Store findStoreWithIdShopsite(Long idShopsite);
}
