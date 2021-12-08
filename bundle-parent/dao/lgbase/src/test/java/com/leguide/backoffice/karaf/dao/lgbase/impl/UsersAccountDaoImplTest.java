package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.UsersAccountDao;
import com.leguide.backoffice.karaf.models.lgbase.users.UsersAccount;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UsersAccountDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UsersAccountDao usersAccountDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(usersAccountDao.findById(100l, 10l));
    }

    @Test
    public void testCreate() throws Exception {
        UsersAccount usersAccount = new UsersAccount();
        usersAccount.setUsersId(1l);
        usersAccount.setAccountId(100l);
        assertNull(usersAccountDao.findById(100l, 1l));
        usersAccountDao.create(usersAccount);
        assertNotNull(usersAccountDao.findById(100l, 1l));
    }

    @Test
    public void testUpdateAccountId() throws Exception {
        assertEquals(100l, usersAccountDao.findById(100l, 2l).getAccountId().longValue());
        usersAccountDao.updateAccountId(101l, 100l, 2l);
        assertEquals(101l, usersAccountDao.findById(101l, 2l).getAccountId().longValue());
    }

    @Ignore
    @Test
    public void testDeleteByUserId() throws Exception {
        assertNotNull(usersAccountDao.findById(100l, 2l));
        usersAccountDao.deleteByUserId(2l);
        assertNull(usersAccountDao.findById(100l, 2l));
    }

    @Test
    public void testDeleteByPk() throws Exception {
        assertNotNull(usersAccountDao.findById(100l, 2l));
        usersAccountDao.deleteByPk(2l, 100l);
        assertNull(usersAccountDao.findById(100l, 2l));
    }

    @Test
    public void testIsUserLinkedToSeveralAccounts() throws Exception {
        assertFalse(usersAccountDao.isUserLinkedToSeveralAccounts(2l));
        assertTrue(usersAccountDao.isUserLinkedToSeveralAccounts(10l));
    }

    @Test
    public void testFindByClientId() throws Exception {
        assertThat(usersAccountDao.findByClientId("CLIENT1")).hasSize(3);
    }
}