package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopRefLanguageDao;
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
public class LgshopRefLanguageDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopRefLanguageDaoImpl refLanguageDao;

    @Test
    public void testFindIdLanguageByCountry() throws Exception {
        assertEquals(1, refLanguageDao.findIdLanguageByCountry(1).intValue());
    }

    @Test
    public void findLocaleByLanguageIdAndCountryIdQuery() throws Exception {
        assertEquals("fr_FR", refLanguageDao.findLocaleByLanguageIdAndCountryIdQuery(1, 1));
    }

    @Test
    public void testFindIdLanguageByCode() throws Exception {
        assertEquals(1, refLanguageDao.findIdLanguageByCode("fr").get().intValue());
    }

    @Test
    public void testFindLocaleByLanguageIdAndCountryAlpha2() throws Exception {
        assertEquals("fr_FR", refLanguageDao.findLocaleByLanguageIdAndCountryAlpha2(1, "FR").get());
    }
}