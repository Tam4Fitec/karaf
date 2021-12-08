package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.UsersOptInOutDao;
import com.leguide.backoffice.karaf.models.lgbase.users.UsersOptInOut;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UsersOptInOutDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UsersOptInOutDao usersOptInOutDao;

    @Test
    public void testCreate() throws Exception {
        UsersOptInOut usersOptInOut = new UsersOptInOut();
        usersOptInOut.setUserId(11l);
        assertNull(usersOptInOutDao.findById(11l));
        usersOptInOutDao.create(usersOptInOut);
        assertNotNull(usersOptInOutDao.findById(11l));
    }

    @Test
    public void testDeleteByUserId() throws Exception {
        assertNotNull(usersOptInOutDao.findById(10l));
        usersOptInOutDao.deleteByUserId(10l);
        assertNull(usersOptInOutDao.findById(10l));
    }
}