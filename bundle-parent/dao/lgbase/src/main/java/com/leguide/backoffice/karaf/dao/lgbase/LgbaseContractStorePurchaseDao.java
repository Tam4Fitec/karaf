package com.leguide.backoffice.karaf.dao.lgbase;

public interface LgbaseContractStorePurchaseDao {

    /**
     * Finds shopsite current purchase
     *
     * @param storeUid storeUid
     * @return current purchase (array with consumption/nb clicks/avg cpc
     */
    Object[] findShopsiteCurrentPurchase(Long storeUid);
}
