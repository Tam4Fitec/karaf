package com.leguide.backoffice.karaf.dao.lgintegration.impl;

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
public class RefFieldDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private RefFieldDaoImpl refFieldDao;

    @Test
    public void testFindFieldLabelById() throws Exception {
        assertEquals("id", refFieldDao.findFieldLabelById(1l));
    }
}