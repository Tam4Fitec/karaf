package com.leguide.backoffice.karaf.webservices.wsclient.beans;

import com.leguide.backoffice.karaf.business.models.pojo.contract.Invoice;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

public class EnrichInvoiceBean {

    public void enrichInvoices(List<Invoice> invoices) {
        for (Invoice invoice : invoices) {
            Date deadline = new Date(new DateTime(invoice.getIssueDate())
                    .plusMonths(1).dayOfMonth().withMaximumValue().getMillis() / 1000);
            invoice.setDeadline(deadline);
            invoice.setIssueDate(new Date(invoice.getIssueDate().getTime() / 1000));
        }
    }
}
