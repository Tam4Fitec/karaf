package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteSociety;

public interface LgshopShopsiteSocietyDao {


	/**
	 * Retrieve LgshopShopsiteSociety object for a given id shopsite
	 * @param idMerchant
	 * @return
	 */
    LgshopShopsiteSociety findById(Long id);

	/**
	 * Create a new LgshopShopsiteSociety
	 * @param lgshopShopsiteSociety
	 */
    void create(LgshopShopsiteSociety lgshopShopsiteSociety);

	/**
	 * update a LgshopShopsiteSociety
	 * @param lgshopShopsiteSociety
	 */
    LgshopShopsiteSociety update(LgshopShopsiteSociety lgshopShopsiteSociety);

	/**
	 * find and returns the libelle of the company type defined by his id label
	 * @param idLabel id_label in rf_label of the company type
	 * @return the company type
	 */
	String findTypeSociety(Long idLabel);
}
