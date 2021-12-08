package com.leguide.backoffice.karaf.dao.lgbase;

import java.util.List;

import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseEcriture;


public interface LgbaseEcritureDao {

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
	List<LgbaseEcriture> getEcritureForClient(String clientId);
}
