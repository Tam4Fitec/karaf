package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteBlackAndWhiteListDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteBlackAndWhiteList;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteBlackAndWhiteListKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgshopShopsiteBlackAndWhiteListDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteBlackAndWhiteListDao blackAndWhiteListDao;

    @Test
    public void testFindBLWLByShopSiteId() throws Exception {
        assertThat(blackAndWhiteListDao.findBLWLByShopSiteId(100l)
                .stream().map(LgshopShopsiteBlackAndWhiteList::getKey).map(LgshopShopsiteBlackAndWhiteListKey::getRefKsiteId).collect(Collectors.toList()))
                .contains(1).doesNotContain(2);
    }

    @Test
    public void testFindForShopsiteAndKsite() throws Exception {
        assertThat(blackAndWhiteListDao.findForShopsiteAndKsite(100l, 1)
                .map(LgshopShopsiteBlackAndWhiteList::getState).map(LgshopShopsiteBlackAndWhiteList.STATES::toString)).contains("WHITELISTED");
        assertThat(blackAndWhiteListDao.findForShopsiteAndKsite(101l, 2)
                .map(LgshopShopsiteBlackAndWhiteList::getState).map(LgshopShopsiteBlackAndWhiteList.STATES::toString)).contains("BLACKLISTED");
    }

    @Test
    public void testAddToList() throws Exception {
        assertThat(blackAndWhiteListDao.findBLWLByShopSiteId(100l)).hasSize(1);
        blackAndWhiteListDao.addToList(100l, 2, LgshopShopsiteBlackAndWhiteList.STATES.BLACKLISTED);
        assertThat(blackAndWhiteListDao.findBLWLByShopSiteId(100l)).hasSize(2);
    }

    @Test
    public void testRemoveFromList() throws Exception {
        assertThat(blackAndWhiteListDao.findBLWLByShopSiteId(101l)).hasSize(1);
        blackAndWhiteListDao.removeFromList(101l, 2);
        assertThat(blackAndWhiteListDao.findBLWLByShopSiteId(101l)).isEmpty();
    }
}