package com.leguide.backoffice.karaf.dao.lgintegration;

import com.leguide.backoffice.karaf.models.lgintegration.catalog.CatalogDTO;


public interface CatalogDao {


	/**
	 * Retourne le catalogue d'un shopsite
	 * @param idShopsite
	 * @return
	 */
    CatalogDTO findByShopsiteId(Long idShopsite);


	Boolean isActiveCatalog(Long idShopsite);


	/**
	 * Create a new Catalog
	 * @param
	 */
	void create(CatalogDTO catalogDTO);


}
