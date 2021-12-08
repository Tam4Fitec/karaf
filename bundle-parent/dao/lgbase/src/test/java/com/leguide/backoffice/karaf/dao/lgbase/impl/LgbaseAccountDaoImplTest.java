package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseAccountDao;
import com.leguide.backoffice.karaf.models.lgbase.account.LgbaseAccount;
import com.leguide.backoffice.karaf.models.lgbase.account.LgbaseAccountClient;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgbaseAccountDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgbaseAccountDao accountDao;

    @Test
    public void testFindById() throws Exception {
        LgbaseAccount accountFound = accountDao.findById(100L);
        assertNotNull(accountFound);
    }

    @Test
    public void testCreate() throws Exception {
        LgbaseAccount account = new LgbaseAccount();
        account.setName("ACCOUNT2");
        account.setCreateDate(new Date());

        assertNull(accountDao.findById(102l));
        accountDao.create(account);
        assertNotNull(account.getAccountId());
        assertNotNull(accountDao.findById(102l));
    }

    @Test
    public void testUpdate() throws Exception {
        LgbaseAccount accountToUpdate = accountDao.findById(100L);
        accountToUpdate.setName("ACCOUNT2_UPDATED");
        accountDao.update(accountToUpdate);
        assertEquals("ACCOUNT2_UPDATED", accountDao.findById(100L).getName());
    }

    @Test
    public void testDelete() throws Exception {
        LgbaseAccount accountToDelete = accountDao.findById(100l);
        accountDao.delete(accountToDelete);
        assertNull(accountDao.findById(100l));
    }

    @Test
    public void testFindClientIdByAccountId() throws Exception {
        assertThat(accountDao.findClientIdByAccountId(200l)).isPresent().contains("CLIENT2");
    }

    @Test
    public void testFindAccountIdByClientId() throws Exception {
        assertThat(accountDao.findAccountIdByClientId("CLIENT2")).isPresent().contains(200l);
        assertThat(accountDao.findAccountIdByClientId("CLIENT3")).isEmpty();
    }

    @Test
    public void testFindAccountByShopsiteId() throws Exception {
        LgbaseAccount account = new LgbaseAccount();
        account.setAccountId(100l);
        assertThat(accountDao.findAccountByShopsiteId(1000l)).isPresent().contains(account);
    }

    @Test
    public void testFindClientIdByShopsiteId() throws Exception {
        assertThat(accountDao.findClientIdByShopsiteId(1000l)).isPresent().contains("CLIENT1");
    }
}