package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopRefKSiteDao;
import com.leguide.backoffice.karaf.models.lgshop.referentiel.LgshopRefKSite;
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
public class LgshopRefKSiteDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopRefKSiteDaoImpl lgshopRefKSiteDao;

    @Test
    public void testFindAllRefSites() throws Exception {
        assertThat(lgshopRefKSiteDao.findAllRefSites()
                .stream().map(LgshopRefKSite::getId).collect(Collectors.toList()))
                .contains(1, 2, 3, 4, 5);
    }


    @Test
    public void testLoadFromDBWithLocalizedValuesQueryZero() throws Exception {
        assertThat(lgshopRefKSiteDao.loadFromDBWithLocalizedValuesQueryZero().keySet()
                .stream().collect(Collectors.toList()))
                .contains(1, 2, 3, 4, 5);
    }

    @Test
    public void testLoadFromDBWithLocalizedValuesQueryLanguage() throws Exception {
        assertThat(lgshopRefKSiteDao.loadFromDBWithLocalizedValuesQueryLanguage(0).keySet()
                .stream().collect(Collectors.toList()))
                .contains(1, 2, 3, 4, 5);
    }
}