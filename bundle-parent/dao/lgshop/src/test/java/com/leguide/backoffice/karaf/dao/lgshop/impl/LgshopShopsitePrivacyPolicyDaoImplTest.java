package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsitePrivacyPolicyDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsitePrivacyPolicy;
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
public class LgshopShopsitePrivacyPolicyDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsitePrivacyPolicyDao privacyPolicyDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(privacyPolicyDao.findById(2094l));
    }

    @Test
    public void testUpdate() throws Exception {
        LgshopShopsitePrivacyPolicy privacyPolicy = privacyPolicyDao.findById(2094l);
        assertEquals("Y", privacyPolicy.getCaterToIndividuals());
        privacyPolicy.setCaterToIndividuals("N");
        privacyPolicyDao.update(privacyPolicy);
        assertEquals("N", privacyPolicyDao.findById(2094l).getCaterToIndividuals());
    }

    @Test
    public void testCreate() throws Exception {
        LgshopShopsitePrivacyPolicy privacyPolicy = new LgshopShopsitePrivacyPolicy();
        privacyPolicy.setShopsiteId(2095l);
        assertNull(privacyPolicyDao.findById(2095l));
        privacyPolicyDao.create(privacyPolicy);
        assertNotNull(privacyPolicyDao.findById(2095l));
    }
}