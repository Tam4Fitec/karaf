package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseInvoiceDao;
import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseInvoice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgbaseInvoiceDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgbaseInvoiceDao invoiceDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(invoiceDao.findById(100l));
    }

    @Test
    public void testFindLastInvoices() throws Exception {
        List<Long> invoices = invoiceDao.findLastInvoices("CLIENT1")
                .stream().map(LgbaseInvoice::getInvoiceCode).collect(Collectors.toList());
        assertThat(invoices).contains(100l, 200l).doesNotContain(300l);
    }

    @Test
    public void testFindLastWritedInvoices() throws Exception {
        List<Long> invoices = invoiceDao.findLastWritedInvoices("CLIENT1")
                .stream().map(LgbaseInvoice::getInvoiceCode).collect(Collectors.toList());
        assertThat(invoices).contains(100l).doesNotContain(200l, 300l);
    }

    @Test
    public void testFindAllInvoicesOfBankCardClientsEditedInMonth() throws Exception {
        List<Long> invoices = invoiceDao.findAllInvoicesOfBankCardClientsEditedInMonth(4, 2015)
                .stream().map(LgbaseInvoice::getInvoiceCode).collect(Collectors.toList());
        assertThat(invoices).contains(100l).doesNotContain(200l, 300l);
    }

    @Test
    public void testUpdate() throws Exception {

    }
}