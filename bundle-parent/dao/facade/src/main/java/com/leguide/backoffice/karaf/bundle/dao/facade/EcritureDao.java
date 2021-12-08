package com.leguide.backoffice.karaf.bundle.dao.facade;

import java.util.List;
import java.util.Map;

public interface EcritureDao {

	/**
	 *  Retourne la balance d'un client
	 *  sum(debit)-sum(credit) 
	 * @param clientId
	 * @return
	 */
	Double getBalance(String clientId);
	
	
	/**
	 * Retourne les écritures comptable d'un client
	 * @param clientId
	 * @return
	 */
	List<Map<String, Object>> getEcrituresForExport(String clientId);
	
}
