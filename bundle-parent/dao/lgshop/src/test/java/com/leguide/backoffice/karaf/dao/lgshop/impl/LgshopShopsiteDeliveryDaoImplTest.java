package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteDeliveryDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteDelivery;
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
public class LgshopShopsiteDeliveryDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteDeliveryDaoImpl shopsiteDeliveryDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(shopsiteDeliveryDao.findById(2094l));
    }

    @Test
    public void testUpdate() throws Exception {
        LgshopShopsiteDelivery delivery = shopsiteDeliveryDao.findById(2094l);
        assertEquals(15l, delivery.getCoolingOffPeriod(), 0.0);
        delivery.setCoolingOffPeriod(10l);
        shopsiteDeliveryDao.update(delivery);
        assertEquals(10l, shopsiteDeliveryDao.findById(2094l).getCoolingOffPeriod(), 0.0);
    }

    @Test
    public void testCreate() throws Exception {
        LgshopShopsiteDelivery delivery = new LgshopShopsiteDelivery();
        delivery.setCoolingOffPeriod(15l);
        delivery.setShopsiteId(2095l);
        assertNull(shopsiteDeliveryDao.findById(2095l));
        shopsiteDeliveryDao.create(delivery);
        assertNotNull(shopsiteDeliveryDao.findById(2095l));
    }
}