package com.leguide.backoffice.karaf.bundle.dao.facade;

import com.leguide.backoffice.karaf.business.models.pojo.integration.Catalog;

/**
 * Created by manuel on 19/08/14.
 */
public interface CatalogDao {

	/**
	 * Retourne le catalogue d'un shopsite
	 * @param idShopsite
	 * @return
	 */
    Catalog findByShopsiteId(Long idShopsite);


	/**
	 * Retourne vrai si catalog actif
	 * @param idShopsite
	 * @return
	 */
    Boolean isActiveCatalog(Long idShopsite);

	/**
	 * Create catalog
	 * @param catalog
     */
	public void create(Catalog catalog);

}
