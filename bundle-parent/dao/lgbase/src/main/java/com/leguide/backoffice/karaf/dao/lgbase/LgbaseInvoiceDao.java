package com.leguide.backoffice.karaf.dao.lgbase;

import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseInvoice;

import java.util.List;

public interface LgbaseInvoiceDao {

	LgbaseInvoice findById(Long invoiceId);

    List<LgbaseInvoice> findLastInvoices(String clientId);

    List<LgbaseInvoice> findLastWritedInvoices(String clientId);

    List<LgbaseInvoice> findAllInvoicesOfBankCardClientsEditedInMonth(int month, int year);

    void update(LgbaseInvoice invoice);
}
