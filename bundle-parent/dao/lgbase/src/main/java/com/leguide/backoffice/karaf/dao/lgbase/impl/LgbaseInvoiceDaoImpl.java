package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseInvoiceDao;
import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseInvoice;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LgbaseInvoiceDaoImpl implements LgbaseInvoiceDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public LgbaseInvoice findById(Long invoiceId) {
        return em.find(LgbaseInvoice.class, invoiceId);
    }

    @Override
    public List<LgbaseInvoice> findLastInvoices(String clientId) {
        TypedQuery<LgbaseInvoice> query = em.createNamedQuery(LgbaseInvoice.FIND_LAST_INVOICES, LgbaseInvoice.class);
        query.setParameter("clientId", clientId);
        query.setMaxResults(12);
        return query.getResultList();
    }

    @Override
    public List<LgbaseInvoice> findLastWritedInvoices(String clientId) {
        TypedQuery<LgbaseInvoice> query = em.createNamedQuery(LgbaseInvoice.FIND_LAST_WRITED_INVOICES, LgbaseInvoice.class);
        query.setParameter(1, clientId);
        query.setMaxResults(12);
        return query.getResultList();
    }

    @Override
    public List<LgbaseInvoice> findAllInvoicesOfBankCardClientsEditedInMonth(int month, int year) {
        TypedQuery<LgbaseInvoice> query = em.createNamedQuery(LgbaseInvoice.FIND_ALL_INVOICES_FOR_CB_CLIENTS_EDITED_IN_MONTH, LgbaseInvoice.class);
        DateTime dateEdition = new DateTime(year, month, 1, 0, 0, 0);
        query.setParameter(1, dateEdition.toDate());
        query.setParameter(2, dateEdition.dayOfMonth().withMaximumValue().secondOfDay().withMaximumValue().toDate());
        return query.getResultList();
    }

    @Override
    public void update(LgbaseInvoice invoice) {
        em.merge(invoice);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
