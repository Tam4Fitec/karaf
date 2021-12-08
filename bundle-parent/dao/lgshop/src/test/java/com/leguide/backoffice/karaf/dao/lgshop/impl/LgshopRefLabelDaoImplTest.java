package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopRefLabelDao;
import com.leguide.backoffice.karaf.models.lgshop.referentiel.LgshopRefLabel;
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
public class LgshopRefLabelDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopRefLabelDao refLabelDao;

    @Test
    public void testFindActiveLabelsForNamespaceAndLocale() throws Exception {
        assertThat(refLabelDao.findActiveLabelsForNamespaceAndLocale("payment_card", "fr_FR")
            .stream().map(LgshopRefLabel::getLabelId).collect(Collectors.toList())).contains(1, 2, 3, 4, 5);
        assertThat(refLabelDao.findActiveLabelsForNamespaceAndLocale("payment_card", "de_DE")).isEmpty();
    }
}