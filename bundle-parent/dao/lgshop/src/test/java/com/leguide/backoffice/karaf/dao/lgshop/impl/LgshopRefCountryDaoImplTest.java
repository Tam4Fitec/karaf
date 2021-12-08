package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopRefCountryDao;
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
public class LgshopRefCountryDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopRefCountryDao lgshopRefCountryDao;

    @Test
    public void testFindInternalCountryByAlpha2Code() throws Exception {
        assertEquals(1, lgshopRefCountryDao.findInternalCountryByAlpha2Code("FR").intValue());
    }

    @Test
    public void testFindAlpha2CodeByInternalId() throws Exception {
        assertEquals("FR", lgshopRefCountryDao.findAlpha2CodeByInternalId(1));
    }
}