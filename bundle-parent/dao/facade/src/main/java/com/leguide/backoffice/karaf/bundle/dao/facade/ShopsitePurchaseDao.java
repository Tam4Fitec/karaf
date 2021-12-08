package com.leguide.backoffice.karaf.bundle.dao.facade;

import com.leguide.backoffice.karaf.business.models.pojo.consumption.ShopsitePurchase;

public interface ShopsitePurchaseDao {

    /**
     * Finds shopsite current purchase
     * @param shopsiteId shopsiteId
     * @return current purchase
     */
    ShopsitePurchase findShopsiteCurrentPurchase(Long shopsiteId);
}
