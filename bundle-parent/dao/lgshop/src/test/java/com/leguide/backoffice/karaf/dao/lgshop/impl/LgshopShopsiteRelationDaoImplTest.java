package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopLightShopsite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgshopShopsiteRelationDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteRelationDaoImpl relationDao;

    @Test
    public void testFindIdsByShopsiteAndNamespace() throws Exception {
        assertThat(relationDao.findIdsByShopsiteAndNamespace(2094l, "command_mode"))
                .hasSize(4)
                .contains(1, 2, 3, 4);
    }

    @Test
    public void testCreateForShopsiteAndNamespace() throws Exception {
        relationDao.createForShopsiteAndNamespace(Arrays.asList(1, 2), 2095l, "command_mode");
        assertThat(relationDao.findIdsByShopsiteAndNamespace(2095l, "command_mode"))
                .hasSize(2)
                .contains(1, 2);
    }

    @Test
    public void testDeleteAllForShopsiteAndNamespace() throws Exception {
        relationDao.deleteAllForShopsiteAndNamespace(2094l, "command_mode");
        assertThat(relationDao.findIdsByShopsiteAndNamespace(2094l, "command_mode")).isEmpty();
    }
}