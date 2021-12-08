package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteSociety;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteState;
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
public class LgshopShopsiteStateDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteStateDaoImpl stateDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(stateDao.findById(2094l));
    }

    @Test
    public void testCreate() throws Exception {
        LgshopShopsiteState state = new LgshopShopsiteState();
        state.setShopsiteId(2095l);
        assertNull(stateDao.findById(2095l));
        stateDao.create(state);
        assertNotNull(stateDao.findById(2095l));
    }

    @Test
    public void testUpdate() throws Exception {
        LgshopShopsiteState state = stateDao.findById(2094l);
        assertEquals(10l, state.getZeusNotation(), 0.0);
        state.setZeusNotation(5l);
        stateDao.update(state);
        assertEquals(5l, stateDao.findById(2094l).getZeusNotation(), 0.0);
    }
}