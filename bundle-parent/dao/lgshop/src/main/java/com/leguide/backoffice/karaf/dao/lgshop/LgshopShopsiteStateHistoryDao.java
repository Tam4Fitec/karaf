package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteState;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteStateHistory;

public interface LgshopShopsiteStateHistoryDao {

	/**
	 * Create a new shopsiteSandbox
	 * @param newShopsiteSandbox
	 */
    void create(LgshopShopsiteState lgshopShopsiteState);

	/**
	 * Create a new shopsiteSandbox
	 * @param user the use who is doing the modification of the state
	 * @param newShopsiteSandbox
	 */
    void create(LgshopShopsiteState history, String user);

    /**
     * Find last state of a given shopsite
     * @param shopsiteId shopsite ID
     * @return last state of a given shopsite
     */
    LgshopShopsiteStateHistory findPenultimateStateOfShopsite(Long shopsiteId);


}
