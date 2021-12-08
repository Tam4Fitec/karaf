package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.StoreDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class StoreDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private StoreDao storeDao;

    @Test
    public void testFindStoreWithIdShopsite() throws Exception {
        assertNotNull(storeDao.findStoreWithIdShopsite(1000l));
    }
}