package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteListing;

public interface LgshopShopsiteListingDao {


	/**
	 *
	 * @param id
	 * @return
	 */
    LgshopShopsiteListing findById(Long id);


	/**
	 *
	 * @param lgshopShopsiteListing
	 */
    void create(LgshopShopsiteListing lgshopShopsiteListing);

	/**
	 *
	 * @param LgshopShopsiteListing
	 * @return
	 */
    LgshopShopsiteListing update(LgshopShopsiteListing lgshopShopsiteListing);

}
