package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteListing;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteSandbox;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteSociety;
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
public class LgshopShopsiteSocietyDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteSocietyDaoImpl societyDao;

    @Test
    public void testCreate() throws Exception {
        LgshopShopsiteSociety society = new LgshopShopsiteSociety();
        society.setShopsiteId(2095l);
        assertNull(societyDao.findById(2095l));
        societyDao.create(society);
        assertNotNull(societyDao.findById(2095l));
    }

    @Test
    public void testFindById() throws Exception {
        assertNotNull(societyDao.findById(2094l));
    }

    @Test
    public void testFindTypeSociety() throws Exception {
        assertEquals("SA", societyDao.findTypeSociety(1l));
    }

    @Test
    public void testUpdate() throws Exception {
        LgshopShopsiteSociety society = societyDao.findById(2094l);
        assertEquals("477181186", society.getSiretNumber());
        society.setSiretNumber("999999999");
        societyDao.update(society);
        assertEquals("999999999", societyDao.findById(2094l).getSiretNumber());
    }
}