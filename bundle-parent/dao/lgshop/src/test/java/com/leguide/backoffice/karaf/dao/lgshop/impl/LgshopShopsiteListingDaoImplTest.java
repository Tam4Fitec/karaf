package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteListingDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteInternalNotification;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteListing;
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
public class LgshopShopsiteListingDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteListingDao listingDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(listingDao.findById(2094l));
    }

    @Test
    public void testCreate() throws Exception {
        LgshopShopsiteListing listing = new LgshopShopsiteListing();
        listing.setShopsiteId(2095l);
        assertNull(listingDao.findById(2095l));
        listingDao.create(listing);
        assertNotNull(listingDao.findById(2095l));
    }

    @Test
    public void testUpdate() throws Exception {
        LgshopShopsiteListing listing = listingDao.findById(2094l);
        assertEquals("Y", listing.getPhysicalShop());
        listing.setPhysicalShop("N");
        listingDao.update(listing);
        assertEquals("N", listingDao.findById(2094l).getPhysicalShop());
    }
}