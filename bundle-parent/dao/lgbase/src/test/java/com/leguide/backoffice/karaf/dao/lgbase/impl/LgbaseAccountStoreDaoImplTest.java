package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseAccountDao;
import com.leguide.backoffice.karaf.dao.lgbase.LgbaseAccountStoreDao;
import com.leguide.backoffice.karaf.models.lgbase.account.LgbaseAccount;
import com.leguide.backoffice.karaf.models.lgbase.account.LgbaseAccountStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgbaseAccountStoreDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgbaseAccountStoreDao accountStoreDao;

    @Test
    public void testCreate() throws Exception {
        LgbaseAccountStore accountStore = new LgbaseAccountStore();
        accountStore.setStoreUid(2000l);
        accountStore.setAccountUid(200l);

        assertNull(accountStoreDao.findById(2000l));
        accountStoreDao.create(accountStore);
        assertNotNull(accountStoreDao.findById(2000l));
    }

    @Test
    public void testUpdate() throws Exception {
        LgbaseAccountStore accountStoreToUpdate = accountStoreDao.findById(1000l);
        accountStoreToUpdate.setAccountUid(101l);
        accountStoreDao.update(accountStoreToUpdate);
        assertEquals(101l, accountStoreDao.findById(1000l).getAccountUid().longValue());
    }

    @Test
    public void testFindById() throws Exception {
        assertNotNull(accountStoreDao.findById(1000l));
    }

    @Test
    public void testGetListIdShopsiteByAccountId() throws Exception {
        List<Long> shopsites = accountStoreDao.getListIdShopsiteByAccountId(100l);
        assertThat(shopsites).contains(1000l, 1001l).doesNotContain(9999l);
    }

    @Test
    public void testGetByIdShopsite() throws Exception {
        assertThat(accountStoreDao.getByIdShopsite(1000l)).isPresent().contains(100l);
    }

    @Test
    public void testGetListByClientId() throws Exception {
        List<LgbaseAccountStore> accountStores = accountStoreDao.getListByClientId("CLIENT1");
        assertThat(accountStores.stream().map(LgbaseAccountStore::getStoreUid).collect(Collectors.toList()))
                .contains(1000l, 1001l).doesNotContain(9999l);
    }
}