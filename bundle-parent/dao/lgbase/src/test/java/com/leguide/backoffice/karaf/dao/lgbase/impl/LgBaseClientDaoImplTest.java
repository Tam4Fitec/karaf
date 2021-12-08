package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgBaseClientDao;
import com.leguide.backoffice.karaf.models.lgbase.client.LgBaseClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgBaseClientDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgBaseClientDao clientDao;

    @Test
    public void testFindClient() throws Exception {
        assertNotNull(clientDao.findClient("CLIENT1"));
    }

    @Test
    public void testFindClientByShopsiteId() throws Exception {
        assertEquals("CLIENT1", clientDao.findClientByShopsiteId("1000").getClientId());
    }

    @Test
    public void testCreate() throws Exception {
        LgBaseClient client = new LgBaseClient();
        client.setClientId("CLIENT2");
        client.setCreationDate(new Date());
        client.setGroupId(0l);
        client.setSage(false);
        client.setSendInvoice(false);

        assertNull(clientDao.findClient("CLIENT2"));
        clientDao.create(client);
        assertNotNull(clientDao.findClient("CLIENT2"));
    }

    @Test
    public void testUpdate() throws Exception {
        LgBaseClient client = clientDao.findClient("CLIENT1");
        assertEquals(0l, client.getGroupId().longValue());
        client.setGroupId(2l);
        clientDao.update(client);
        assertEquals(2l, clientDao.findClient("CLIENT1").getGroupId().longValue());
    }

    @Test
    public void testDefineAsSageSource() throws Exception {
        assertFalse(clientDao.findClient("CLIENT1").isSage());
        clientDao.defineAsSageSource("CLIENT1");
        assertTrue(clientDao.findClient("CLIENT1").isSage());
    }
}