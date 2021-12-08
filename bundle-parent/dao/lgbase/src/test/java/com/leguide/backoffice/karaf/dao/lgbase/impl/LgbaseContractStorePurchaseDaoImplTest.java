package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseContractStorePurchaseDao;
import com.leguide.backoffice.karaf.dao.lgbase.utils.DateMock;
import org.joda.time.DateTimeUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgbaseContractStorePurchaseDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgbaseContractStorePurchaseDao contractStorePurchaseDao;

    @Ignore
    @Test
    public void testFindShopsiteCurrentPurchase() throws Exception {
        DateTimeUtils.setCurrentMillisProvider(new DateMock("20/04/2015 08:00:00"));
        assertNotNull(contractStorePurchaseDao.findShopsiteCurrentPurchase(1000l)[0]);
    }
}