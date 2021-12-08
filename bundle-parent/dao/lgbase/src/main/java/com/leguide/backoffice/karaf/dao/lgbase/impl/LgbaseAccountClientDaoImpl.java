package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseAccountClientDao;
import com.leguide.backoffice.karaf.models.lgbase.account.LgbaseAccountClient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LgbaseAccountClientDaoImpl implements LgbaseAccountClientDao {

    @PersistenceContext
    private EntityManager em;

    public LgbaseAccountClientDaoImpl() {
        super();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


    @Override
    public LgbaseAccountClient findById(Long accountId) {
        return em.find(LgbaseAccountClient.class, accountId);
    }

    @Override
    public LgbaseAccountClient findMasterByClientId(String clientId) {
        TypedQuery<LgbaseAccountClient> query = em.createNamedQuery(LgbaseAccountClient.FIND_MASTER_ACCOUNT_BY_CLIENT_ID, LgbaseAccountClient.class);
        query.setParameter(1, clientId);
        return query.getSingleResult();
    }

    @Override
    public void delete(LgbaseAccountClient accountToDelete) {
        em.remove(em.contains(accountToDelete) ? accountToDelete : em.merge(accountToDelete));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> findClientWithMultipleAccount() {
        Query query = em.createNamedQuery(LgbaseAccountClient.FIND_CLIENTID_WITH_MULTIPLE_ACCOUNTID, String.class);
        List<String> listClient = query.getResultList();
        return listClient;
    }


}
