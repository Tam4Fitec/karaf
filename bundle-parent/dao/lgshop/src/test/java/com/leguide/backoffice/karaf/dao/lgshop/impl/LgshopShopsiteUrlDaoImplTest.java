package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteUrl;
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
public class LgshopShopsiteUrlDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteUrlDaoImpl urlDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(urlDao.findById(2094l));
    }

    @Test
    public void testCreate() throws Exception {
        LgshopShopsiteUrl url = new LgshopShopsiteUrl();
        url.setShopsiteId(2095l);
        assertNull(urlDao.findById(2095l));
        urlDao.create(url);
        assertNotNull(urlDao.findById(2095l));
    }

    @Test
    public void testUpdate() throws Exception {
        String newUrlTracked = "http://www.laredoute.fr/?cod=33fr12314847NEW";
        LgshopShopsiteUrl url = urlDao.findById(2094l);
        assertEquals("http://www.laredoute.fr/?cod=33fr12314847", url.getShopUrlTracked());
        url.setShopUrlTracked(newUrlTracked );
        urlDao.update(url);
        assertEquals(newUrlTracked , urlDao.findById(2094l).getShopUrlTracked());
    }
}