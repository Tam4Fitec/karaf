package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteUrl;

public interface LgshopShopsiteUrlDao {

	/**
	 * Find a LgshopShopsiteUrl for a given id shopsite
	 * @param idShopsite id shopsite
	 * @return the shopsite url corresponding to the id shopsite
	 */
    LgshopShopsiteUrl findById(Long idShopsite);

	/**
	 * Create a new shopsiteUrl
	 * @param newShopsiteUrl
	 */
    void create(LgshopShopsiteUrl newShopsiteUrl);


	LgshopShopsiteUrl update(LgshopShopsiteUrl newShopsiteUrl);
}
