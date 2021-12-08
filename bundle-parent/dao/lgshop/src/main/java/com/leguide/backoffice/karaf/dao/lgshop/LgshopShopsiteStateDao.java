package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteState;

public interface LgshopShopsiteStateDao {

	/**
	 * Find a LgshopShopsiteState for a given id shopsite
	 * @param idShopsite id shopsite
	 * @return the shopsite state corresponding to the id shopsite
	 */
    LgshopShopsiteState findById(Long idShopsite);

	/**
	 * Create a new shopsiteState
	 * @param newShopsiteState
	 */
    void create(LgshopShopsiteState newShopsiteState);

	/**
	 * update a shopsite state
	 * @param lgshopShopsiteState object to update
	 */
    void update(LgshopShopsiteState lgshopShopsiteState);


}
