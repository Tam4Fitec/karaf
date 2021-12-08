package com.leguide.backoffice.karaf.dao.lgbase.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseAccountDao;
import com.leguide.backoffice.karaf.models.lgbase.account.LgbaseAccount;

@Repository
public class LgbaseAccountDaoImpl implements LgbaseAccountDao {

    @PersistenceContext
    private EntityManager em;

    public LgbaseAccountDaoImpl() {
        super();
    }

    @Override
    public LgbaseAccount findById(Long accountId) {
        return em.find(LgbaseAccount.class, accountId);
    }

    @Override
    public void create(LgbaseAccount newAccount) {
        em.persist(newAccount);
    }

    @Override
    public void update(LgbaseAccount accountToUpdate) {
        em.merge(accountToUpdate);
    }

    @Override
    public void delete(LgbaseAccount accountToDelete) {
        em.remove(accountToDelete);
    }

    @Override
    public Optional<String> findClientIdByAccountId(Long accountId) {
        TypedQuery<String> query = em.createNamedQuery(LgbaseAccount.FIND_CLIENTID_BY_ACCOUNTID, String.class);
        query.setParameter(1, accountId);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public List<Long> findShopsiteIdsOfAccount(Long accountId) {
    	TypedQuery<Number> query = em.createNamedQuery(LgbaseAccount.FIND_SHOPSITE_IDS_BY_ACCOUNTID, Number.class);
    	query.setParameter(1, accountId);
    	return query.getResultList().stream().map(Number::longValue).collect(Collectors.toList());
    }

    @Override
    public Optional<Long> findAccountIdByClientId(String clientId) {
        TypedQuery<Number> query = em.createNamedQuery(LgbaseAccount.FIND_ACCOUNTID_BY_CLIENTID, Number.class);
        query.setParameter(1, clientId);
        return query.getResultList().stream().map(Number::longValue).findFirst();
    }

    @Override
    public Optional<LgbaseAccount> findAccountByShopsiteId(Long shopsiteId) {
        TypedQuery<LgbaseAccount> query = em.createNamedQuery(LgbaseAccount.FIND_ACCOUNT_BY_SHOPSITEID, LgbaseAccount.class);
        query.setParameter(1, shopsiteId);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public List<LgbaseAccount> findAccountsByUserId(Long userId) {
    	TypedQuery<LgbaseAccount> query = em.createNamedQuery(LgbaseAccount.FIND_ACCOUNTS_BY_USERID, LgbaseAccount.class);
    	query.setParameter(1, userId);
    	return query.getResultList();
    }

    @Override
    public Optional<String> findClientIdByShopsiteId(Long shopsiteId) {
        TypedQuery<String> query = em.createNamedQuery(LgbaseAccount.FIND_CLIENT_ID_BY_SHOPSITEID, String.class);
        query.setParameter(1, shopsiteId);
        return query.getResultList().stream().findFirst();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
