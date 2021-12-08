package com.leguide.backoffice.karaf.webservices.offercategorization.dao;

import com.leguide.backoffice.karaf.webservices.offercategorization.exception.LoadException;

/**
 *
 * @author tam-vinh.huynh
 *
 */
public interface LoadShopsiteDAO {

	/**
	 * Retourne l'identifiant id_shopsite en fonction de l'id marchand et du pays
	 * @param country
	 * @param storeId
	 * @return
	 * @throws LoadException
	 */
	public Long getIdShopsite(String country, String storeId)throws LoadException;

}