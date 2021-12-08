package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteSandbox;

public interface LgshopShopsiteSandboxDao {

	/**
	 * Create a new shopsiteSandbox
	 * @param newShopsiteSandbox
	 */
    void create(LgshopShopsiteSandbox newShopsiteSandbox);

	/**
	 * Retrieve the delivery zone by country
	 * @param countryId
	 * @return
	 */
    Long findDeliveryZoneByIdCountry(Integer countryId);


}
