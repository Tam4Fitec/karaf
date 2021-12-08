package com.leguide.backoffice.karaf.bundle.dao.facade;

import java.util.List;

import com.leguide.backoffice.karaf.business.models.pojo.contract.Invoice;

public interface InvoiceDao {

	Invoice findById(Long invoiceId);

    List<Invoice> findLastInvoices(String clientId);

    List<Invoice> findLastWritedInvoices(String clientId);

    List<Invoice> findAllInvoicesOfBankCardClientsEditedInMonth(int month, int year);
}
