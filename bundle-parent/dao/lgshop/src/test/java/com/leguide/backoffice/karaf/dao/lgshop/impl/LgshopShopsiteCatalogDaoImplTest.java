package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteCatalogDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteCatalog;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteCatalogModeEnum;
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
public class LgshopShopsiteCatalogDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteCatalogDaoImpl catalogDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(catalogDao.findById(1l));
    }

    @Test
    public void testCreate() throws Exception {
        assertNull(catalogDao.findById(2l));
        LgshopShopsiteCatalog catalog = new LgshopShopsiteCatalog();
        catalog.setShopsiteId(2l);
        catalog.setMode(LgshopShopsiteCatalogModeEnum.automatic);
        catalog.setCatalogUrl("http://www.leguide.com/catalog");
        catalog.setCatalogFtp("N");
        catalog.setEcommerceId(0);
        catalog.setEcommerceOther("");
        catalogDao.create(catalog);
        assertNotNull(catalogDao.findById(2l));
    }
}