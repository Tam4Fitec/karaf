package com.leguide.backoffice.karaf.dao.lgshop;

import java.util.List;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopLightShopsite;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsite;

public interface LgshopShopsiteDao {

	/**
	 * Retrieve LgshopShopsite object for a given id shopsite
	 * @param idMerchant
	 * @return
	 */
    LgshopShopsite findById(Long id);

	/**
	 * Retrieve light shopsite info for Zeus for a given shopsiteId
	 * @param id
	 * @return
	 */
    LgshopLightShopsite findLightShopInfoById(String id);

	/**
	 * Retrieve a list of light shopsites info for Zeus for a given shopsiteId
	 * @param id
	 * @return
	 */
    List<LgshopLightShopsite> findLightShopInfoByIds(String[] ids);

    /**
     * Retrieve a list of light shopsites info for Zeus for a given zeusNotation
     * @param zeusNotation
     * @param limit
     * @param offset
     * @return
     */
    List<LgshopLightShopsite> findLightShopInfoByZeusNotation(Integer zeusNotation, Integer limit, Integer offset);

	/**
	 * Create a new shopsite
	 * @param newShopsite
	 */
    void create(LgshopShopsite newShopsite);

	/**
	 * update the shopsite
	 * @param lgshopShopsite the shopsite to update
	 */
    void update(LgshopShopsite lgshopShopsite);


	/**
	 * Retrieve a list of shopsiteId for a given languageId and idRefState
	 * @param languageId
	 * @param idRefState
	 * @return
	 */
	 List<Long> findListShopIdByLanguageAndRefState(Long languageId, Long idRefState);

	/**
	 * Retrieve a list of light shopsites for a given ksite
	 * @param ksite
	 * @return
	 */
	List<LgshopLightShopsite> findLightShopInfoByKSite(long ksite);

	/**
	 *
	 * @param comId
	 * @param shopId
	 * @param name
     */
	void createShopMapping(Long comId, Long shopId, String name,String languague, String locale);


	String retrieveLocale(Long shopsiteId);
}
