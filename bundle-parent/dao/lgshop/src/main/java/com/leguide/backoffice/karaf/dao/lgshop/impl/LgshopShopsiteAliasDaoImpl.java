package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteAliasDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteAlias;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LgshopShopsiteAliasDaoImpl implements LgshopShopsiteAliasDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public LgshopShopsiteAlias findById(Long id) {
        return em.find(LgshopShopsiteAlias.class, id);
    }

    @Override
    public void create(LgshopShopsiteAlias lgshopShopsiteAlias) {
        em.persist(lgshopShopsiteAlias);
    }

    @Override
    public void update(LgshopShopsiteAlias lgshopShopsiteAlias) {
        em.merge(lgshopShopsiteAlias);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
