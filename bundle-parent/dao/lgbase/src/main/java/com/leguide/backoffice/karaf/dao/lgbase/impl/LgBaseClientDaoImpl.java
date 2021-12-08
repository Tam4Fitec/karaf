package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgBaseClientDao;
import com.leguide.backoffice.karaf.models.lgbase.client.LgBaseClient;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Repository
public class LgBaseClientDaoImpl implements LgBaseClientDao {

    @PersistenceContext
	private EntityManager em;

	@Override
	public LgBaseClient findClient(String clientId) {
		try {
			return em.find(LgBaseClient.class, clientId);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public LgBaseClient findClientByShopsiteId(String shopsiteId) {
		Query query = em.createNativeQuery("SELECT cli.* FROM lg_client cli inner join lg_account_client acc on cli.client_id = acc.clientid inner join tb_account_store acs on acs.account_uid = acc.accountid WHERE acs.store_uid = ?", LgBaseClient.class);
		query.setParameter(1, shopsiteId);
		try {
			return (LgBaseClient)query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void create(LgBaseClient client) {
		em.persist(client);
	}

	@Override
	public void update(LgBaseClient client) {
		em.merge(client);
	}

	@Override
	public void defineAsSageSource(String clientId) {
        LgBaseClient client = findClient(clientId);
        client.setSage(true);
        update(client);
	}

	@Override
	public void updateReglementMode(String clientId, String type) {
        LgBaseClient client = findClient(clientId);
        client.setPaymentMeanType(type);
        update(client);
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
