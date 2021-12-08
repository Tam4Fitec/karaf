package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopRefLabelDao;
import com.leguide.backoffice.karaf.models.lgshop.referentiel.LgshopRefLabel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LgshopRefLabelDaoImpl implements LgshopRefLabelDao {

    @PersistenceContext
    private EntityManager em;

    public LgshopRefLabelDaoImpl() {

    }

    @Override
    public List<LgshopRefLabel> findActiveLabelsForNamespaceAndLocale(String namespace, String locale) {
        TypedQuery<LgshopRefLabel> query = em.createNamedQuery(LgshopRefLabel.FIND_ACTIVE_BY_NAMESPACE_AND_LOCALE, LgshopRefLabel.class);
        query.setParameter("namespace", namespace);
        query.setParameter("locale", locale);
        return query.getResultList();
    }

    public EntityManager getEm() {
        return em;
    }

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
