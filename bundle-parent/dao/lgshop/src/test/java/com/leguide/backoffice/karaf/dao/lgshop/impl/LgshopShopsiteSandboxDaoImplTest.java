package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteDelivery;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteSandbox;
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
public class LgshopShopsiteSandboxDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteSandboxDaoImpl sandboxDao;

    @Test
    public void testCreate() throws Exception {
        LgshopShopsiteSandbox sandbox = new LgshopShopsiteSandbox();
        sandbox.setShopsiteId(2095l);
        assertNull(sandboxDao.findById(2095l));
        sandboxDao.create(sandbox);
        assertNotNull(sandboxDao.findById(2095l));
    }

    // ignore because MySQL function "pow" doesn't exist in H2
    @Ignore
    @Test
    public void testFindDeliveryZoneByIdCountry() throws Exception {
        assertNotNull(sandboxDao.findDeliveryZoneByIdCountry(1));
    }
}