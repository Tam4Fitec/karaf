package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseContractStoreConsumptionDao;
import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseContractStoreConsumption;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgbaseContractStoreConsumptionDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgbaseContractStoreConsumptionDao contractStoreConsumptionDao;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void testFindByStoreFromDate() throws Exception {
        List<LgbaseContractStoreConsumption> result = contractStoreConsumptionDao.findByStoreFromDate(
                1000l,
                sdf.parse(sdf.format(DateTime.now().withDate(2015, 3, 20).toDate())));
        assertThat(result).hasSize(2);
    }

    @Test
    public void testFindByStoreAtDate() throws Exception {
        Optional<LgbaseContractStoreConsumption> csc = contractStoreConsumptionDao.findByStoreAtDate(
                1000l,
                sdf.parse(sdf.format(DateTime.now().withDate(2015, 4, 20).toDate())));
        assertThat(csc.map(LgbaseContractStoreConsumption::getConsumptionId)).isPresent().contains(11l);
    }

    @Test
    public void testUpdate() throws Exception {
        LgbaseContractStoreConsumption csc = contractStoreConsumptionDao.findByStoreAtDate(
                1000l,
                sdf.parse(sdf.format(DateTime.now().withDate(2015, 4, 20).toDate()))).get();
        assertEquals(200.0, csc.getMaximumAmount(), 0.0);
        csc.setMaximumAmount(300.0);
        contractStoreConsumptionDao.update(csc);
        assertEquals(300.0, csc.getMaximumAmount(), 0.0);
    }
}