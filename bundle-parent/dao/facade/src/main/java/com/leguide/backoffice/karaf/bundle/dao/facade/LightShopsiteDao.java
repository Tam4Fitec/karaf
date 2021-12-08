package com.leguide.backoffice.karaf.bundle.dao.facade;

import java.util.List;

import com.leguide.backoffice.karaf.business.models.pojo.light.LightShopsite;

public interface LightShopsiteDao {
	/**
	 * Retrieve light shopsite info for Zeus for a given shopsiteId
	 * @param id
	 * @return
	 */
    LightShopsite findLightShopInfoById(String id);

	/**
	 * Retrieve a list of light shopsites info for Zeus for a given shopsiteId
	 * @param id
	 * @return
	 */
    List<LightShopsite> findLightShopInfoByIds(String[] id);

    /**
     * Retrieve a list of light shopsites info for Zeus for a given zeusNotation
     * @param zeusNotation
     * @param limit
     * @param offset
     * @return
     */
    List<LightShopsite> getLightShopInfoByZeusNotation(Integer zeusNotation, Integer limit, Integer offset);

    /**
     * Retrieve a list of light shopsites info for Yahoo for a given KSite
     * @return
     */
	List<LightShopsite> findLightShopInfoByKSite(long ksite);

}
