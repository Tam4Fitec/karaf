package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteReportSubscription;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteReportSubscriptionKey;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgshopShopsiteReportSubscriptionDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteReportSubscriptionDaoImpl reportSubscriptionDao;

    @Test
    public void testFindByShopsiteId() throws Exception {
        LgshopShopsiteReportSubscriptionKey key = new LgshopShopsiteReportSubscriptionKey();
        key.setShopsiteId(2094l);
        key.setContactEmail("test@redoute.fr");
        key.setReportType("STATSCLICKS");
        key.setComplementary("");
        assertNotNull(reportSubscriptionDao.findByShopsiteIdAndEmail(key));
    }

    @Test
    public void testFindShopsiteSubscriptionsDayBetween() throws Exception {
        assertThat(reportSubscriptionDao.findShopsiteSubscriptionsDayBetween(800, 1000)
                .stream().map(LgshopShopsiteReportSubscription::getKey)
                .map(LgshopShopsiteReportSubscriptionKey::getContactEmail).collect(Collectors.toList()))
                .hasSize(1)
                .contains("test2@redoute.fr");

        assertThat(reportSubscriptionDao.findShopsiteSubscriptionsDayBetween(500, 1000)
                .stream().map(LgshopShopsiteReportSubscription::getKey)
                .map(LgshopShopsiteReportSubscriptionKey::getContactEmail).collect(Collectors.toList()))
                .hasSize(2)
                .contains("test@redoute.fr", "test2@redoute.fr");
    }

    @Test
    public void testFindShopsiteSubscriptionsWeekBetween() throws Exception {
        assertThat(reportSubscriptionDao.findShopsiteSubscriptionsWeekBetween(2, 800, 1000)
                .stream().map(LgshopShopsiteReportSubscription::getKey)
                .map(LgshopShopsiteReportSubscriptionKey::getContactEmail).collect(Collectors.toList()))
                .hasSize(4)
                .contains("test2@redoute.fr", "test@company1.fr", "test@company2.fr", "test@company3.fr");

        assertThat(reportSubscriptionDao.findShopsiteSubscriptionsWeekBetween(2, 500, 1000)
                .stream().map(LgshopShopsiteReportSubscription::getKey)
                .map(LgshopShopsiteReportSubscriptionKey::getContactEmail).collect(Collectors.toList()))
                .hasSize(5)
                .contains("test@redoute.fr", "test2@redoute.fr", "test@company1.fr", "test@company2.fr", "test@company3.fr");

        assertThat(reportSubscriptionDao.findShopsiteSubscriptionsWeekBetween(3, 500, 1000))
                .isEmpty();
    }

    @Test
    public void testCreate() throws Exception {
        LgshopShopsiteReportSubscription reportSubscription = new LgshopShopsiteReportSubscription();
        LgshopShopsiteReportSubscriptionKey key = new LgshopShopsiteReportSubscriptionKey();
        key.setShopsiteId(2095l);
        key.setContactEmail("test@leguide.fr");
        key.setReportType("STATSCLICKS");
        reportSubscription.setKey(key);

        assertNull(reportSubscriptionDao.findByShopsiteIdAndEmail(key));
        reportSubscriptionDao.create(reportSubscription);
        assertNotNull(reportSubscriptionDao.findByShopsiteIdAndEmail(key));
    }

    @Test
    public void testUpdate() throws Exception {
        LgshopShopsiteReportSubscriptionKey key = new LgshopShopsiteReportSubscriptionKey();
        key.setShopsiteId(2094l);
        key.setContactEmail("test@redoute.fr");
        key.setReportType("STATSCLICKS");
        key.setComplementary("");
        LgshopShopsiteReportSubscription reportSubscription = reportSubscriptionDao.findByShopsiteIdAndEmail(key);
        assertEquals(600, reportSubscription.getMinuteOfDay(), 0);
        reportSubscription.setMinuteOfDay(400);
        reportSubscriptionDao.update(reportSubscription);
        assertEquals(400, reportSubscriptionDao.findByShopsiteIdAndEmail(key).getMinuteOfDay(), 0);
    }

    @Test
    public void testDelete() throws Exception {
        LgshopShopsiteReportSubscription reportSubscription = new LgshopShopsiteReportSubscription();
        LgshopShopsiteReportSubscriptionKey key = new LgshopShopsiteReportSubscriptionKey();
        key.setShopsiteId(2094l);
        key.setContactEmail("test@redoute.fr");
        key.setReportType("STATSCLICKS");
        key.setComplementary("");
        reportSubscription.setKey(key);

        assertNotNull(reportSubscriptionDao.findByShopsiteIdAndEmail(key));
        reportSubscriptionDao.delete(reportSubscription);
        assertNull(reportSubscriptionDao.findByShopsiteIdAndEmail(key));
    }

    @Test
    public void testFindObsoletePricingSubscription() throws Exception {
        Date beforeDate = DateTime.now().withYear(2016).withMonthOfYear(2).withDayOfMonth(1).withHourOfDay(1).withMinuteOfHour(1).toDate();
        assertThat(reportSubscriptionDao.findObsoletePricingSubscription(beforeDate)
                .stream().map(LgshopShopsiteReportSubscription::getKey)
                .map(LgshopShopsiteReportSubscriptionKey::getShopsiteId).collect(Collectors.toList()))
                .hasSize(1)
                .contains(1000l);
    }
}