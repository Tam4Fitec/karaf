package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseAccountClientDao;
import com.leguide.backoffice.karaf.models.lgbase.account.LgbaseAccountClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgbaseAccountClientDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgbaseAccountClientDao accountClientDao;

    private LgbaseAccountClient accountClient;

    @Before
    public void setUp() {
        accountClient = new LgbaseAccountClient();
        accountClient.setAccountId(100l);
        accountClient.setClientId("CLIENT1");
    }

    @Test
    public void testFindById() throws Exception {
        LgbaseAccountClient accountFound = accountClientDao.findById(100L);
        assertNotNull(accountFound);
        assertEquals(accountClient, accountFound);
    }

    @Test
    public void testFindMasterByClientId() throws Exception {
        LgbaseAccountClient accountFound = accountClientDao.findMasterByClientId("CLIENT1");
        assertNotNull(accountFound);
        assertEquals(accountClient, accountFound);
    }

    @Test
    public void testDelete() throws Exception {
        LgbaseAccountClient accountFound = accountClientDao.findById(100L);
        assertNotNull(accountFound);
        accountClientDao.delete(accountClient);
        assertNull(accountClientDao.findById(100L));
    }

    @Test
    public void testFindClientWithMultipleAccount() throws Exception {
        List<String> result = accountClientDao.findClientWithMultipleAccount();
        assertThat(result).contains("CLIENT1").doesNotContain("CLIENT2");
    }
}