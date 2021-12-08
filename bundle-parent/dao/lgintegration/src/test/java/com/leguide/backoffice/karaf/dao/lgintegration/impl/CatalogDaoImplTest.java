package com.leguide.backoffice.karaf.dao.lgintegration.impl;

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
public class CatalogDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private CatalogDaoImpl catalogDao;

    @Test
    public void testFindByShopsiteId() throws Exception {
        assertNotNull(catalogDao.findByShopsiteId(2094l));
    }

    @Test
    public void testIsActiveCatalog() throws Exception {
        assertTrue(catalogDao.isActiveCatalog(2094l));
    }
}