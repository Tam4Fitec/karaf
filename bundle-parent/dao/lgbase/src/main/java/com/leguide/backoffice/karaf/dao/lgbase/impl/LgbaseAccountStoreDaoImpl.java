package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseAccountStoreDao;
import com.leguide.backoffice.karaf.models.lgbase.account.LgbaseAccountStore;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LgbaseAccountStoreDaoImpl implements LgbaseAccountStoreDao {

    @PersistenceContext
    private EntityManager em;

    public LgbaseAccountStoreDaoImpl() {
        super();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(LgbaseAccountStore newAccountStore) {
        em.persist(newAccountStore);
    }

    @Override
    public LgbaseAccountStore update(LgbaseAccountStore lgbaseAccountStore) {
        return em.merge(lgbaseAccountStore);
    }

    @Override
    public LgbaseAccountStore findById(Long shopSiteId) {
        return em.find(LgbaseAccountStore.class, shopSiteId);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Long> getListIdShopsiteByAccountId(Long accountId) {
        TypedQuery<Number> query = em.createNamedQuery(LgbaseAccountStore.GET_LIST_BY_ACCOUNTID, Number.class);
        query.setParameter(1, accountId);
        return query.getResultList().stream().map(Number::longValue).collect(Collectors.toList());
    }

    @Override
    public Optional<Long> getByIdShopsite(Long idShopsite) {
        TypedQuery<LgbaseAccountStore> jpaQuery = em.createNamedQuery(LgbaseAccountStore.GET_LIST_BY_IDSHOPSITE, LgbaseAccountStore.class);
        jpaQuery.setParameter("idshopsite", idShopsite);
        return jpaQuery.getResultList().stream().findFirst().map(LgbaseAccountStore::getAccountUid);
    }

    @Override
    public List<LgbaseAccountStore> getListByClientId(String clientId) {
        TypedQuery<LgbaseAccountStore> jpaQuery = em.createNamedQuery(LgbaseAccountStore.GET_LIST_BY_IDCLIENT, LgbaseAccountStore.class);
        jpaQuery.setParameter(1, clientId);
        return jpaQuery.getResultList();
    }

}
