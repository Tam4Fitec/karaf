package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteAliasDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteAlias;
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
public class LgshopShopsiteAliasDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteAliasDao aliasDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(aliasDao.findById(100l));
    }

    @Test
    public void testCreate() throws Exception {
        LgshopShopsiteAlias aliasToCreate = new LgshopShopsiteAlias();
        aliasToCreate.setShopsiteId(101l);
        aliasToCreate.setAlias1("alias1");
        aliasToCreate.setAlias2("alias2");
        aliasToCreate.setAlias3("alias3");
        aliasToCreate.setAlias4("alias4");
        aliasToCreate.setAlias5("alias5");

        assertNull(aliasDao.findById(101l));
        aliasDao.create(aliasToCreate);
        assertNotNull(aliasDao.findById(101l));
    }

    @Test
    public void testUpdate() throws Exception {
        String newAlias = "alias1_new";

        LgshopShopsiteAlias alias = aliasDao.findById(100l);
        assertEquals("alias1", aliasDao.findById(100l).getAlias1());
        alias.setAlias1(newAlias);

        aliasDao.update(alias);
        assertEquals(newAlias, aliasDao.findById(100l).getAlias1());
    }
}