package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgshopShopsiteStateHistoryDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteStateHistoryDaoImpl stateHistoryDao;

    @Test
    public void testCreate() throws Exception {
        assertEquals("N", stateHistoryDao.findPenultimateStateOfShopsite(2094l).getShopPatner());

        LgshopShopsiteState state = new LgshopShopsiteState();
        state.setShopsiteId(2094l);
        state.setShopPatner("Y");
        stateHistoryDao.create(state);

        assertEquals("Y", stateHistoryDao.findPenultimateStateOfShopsite(2094l).getShopPatner());
    }

    @Test
    public void testFindPenultimateStateOfShopsite() throws Exception {
        assertEquals("N", stateHistoryDao.findPenultimateStateOfShopsite(2094l).getShopPatner());
    }
}