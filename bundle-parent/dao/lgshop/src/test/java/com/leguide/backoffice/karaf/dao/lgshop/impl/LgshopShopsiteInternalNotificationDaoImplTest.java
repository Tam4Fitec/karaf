package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteDelivery;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteInternalNotification;
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
public class LgshopShopsiteInternalNotificationDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteInternalNotificationDaoImpl internalNotificationDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(internalNotificationDao.findById(2094l));
    }

    @Test
    public void testUpdate() throws Exception {
        LgshopShopsiteInternalNotification internalNotification = internalNotificationDao.findById(2094l);
        assertEquals(5f, internalNotification.getCatalog(), 0.0);
        internalNotification.setCatalog(4f);
        internalNotificationDao.update(internalNotification);
        assertEquals(4f, internalNotificationDao.findById(2094l).getCatalog(), 0.0);
    }

    @Test
    public void testCreate() throws Exception {
        LgshopShopsiteInternalNotification internalNotification = new LgshopShopsiteInternalNotification();
        internalNotification.setShopsiteId(2095l);
        assertNull(internalNotificationDao.findById(2095l));
        internalNotificationDao.create(internalNotification);
        assertNotNull(internalNotificationDao.findById(2095l));
    }
}