package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteBlackAndWhiteListDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteBlackAndWhiteList;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteBlackAndWhiteListKey;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class LgshopShopsiteBlackAndWhiteListDaoImpl implements LgshopShopsiteBlackAndWhiteListDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<LgshopShopsiteBlackAndWhiteList> findBLWLByShopSiteId(Long id) {
        TypedQuery<LgshopShopsiteBlackAndWhiteList> query =
                em.createNamedQuery(LgshopShopsiteBlackAndWhiteList.FIND_ALL_BY_SHOPSITE, LgshopShopsiteBlackAndWhiteList.class);
        query.setParameter("shopsiteId", id);
        return query.getResultList();
    }

    @Override
    public Optional<LgshopShopsiteBlackAndWhiteList> findForShopsiteAndKsite(Long shopsiteId, Integer refKsiteId) {
        TypedQuery<LgshopShopsiteBlackAndWhiteList> query =
                em.createNamedQuery(LgshopShopsiteBlackAndWhiteList.FIND_FOR_SHOPSITE_AND_KSITE, LgshopShopsiteBlackAndWhiteList.class);
        query.setParameter("shopsiteId", shopsiteId);
        query.setParameter("refKsiteId", refKsiteId);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public void addToList(Long shopsiteId, Integer refKsiteId, LgshopShopsiteBlackAndWhiteList.STATES state) {
        LgshopShopsiteBlackAndWhiteList blackAndWhiteList = new LgshopShopsiteBlackAndWhiteList();
        blackAndWhiteList.setKey(new LgshopShopsiteBlackAndWhiteListKey(refKsiteId, shopsiteId));
        blackAndWhiteList.setState(state);
        em.persist(blackAndWhiteList);
    }

    @Override
    public void removeFromList(Long shopsiteId, Integer refKsiteId) {
        findForShopsiteAndKsite(shopsiteId, refKsiteId).ifPresent(em::remove);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}