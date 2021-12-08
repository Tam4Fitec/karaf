package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopLightShopsite;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopStateEnum;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsite;
import org.junit.Ignore;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LgshopShopsiteDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LgshopShopsiteDao shopsiteDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(shopsiteDao.findById(2094l));
    }

    // Ignore for strange bug
    @Ignore
    @Test
    public void testFindLightShopInfoByKSite() throws Exception {
        assertThat(shopsiteDao.findLightShopInfoByKSite(1)
                .stream().map(LgshopLightShopsite::getShopsiteId).collect(Collectors.toList()))
                .hasSize(1)
                .contains(2094l);
    }

    @Test
    public void testFindLightShopInfoById() throws Exception {
        assertThat(shopsiteDao.findLightShopInfoById("2094")).isNotNull();
    }

    @Test
    public void testFindLightShopInfoByIds() throws Exception {
        assertThat(shopsiteDao.findLightShopInfoByIds(new String[]{"2094"})
                .stream().map(LgshopLightShopsite::getShopsiteId).collect(Collectors.toList()))
                .hasSize(1)
                .contains(2094l);
    }

    @Test
    public void testFindLightShopInfoByZeusNotation() throws Exception {
        assertThat(shopsiteDao.findLightShopInfoByZeusNotation(10, 10, 0)
                .stream().map(LgshopLightShopsite::getShopsiteId).collect(Collectors.toList()))
                .hasSize(1)
                .contains(2094l);
    }

    @Test
    public void testFindListShopIdByLanguageAndRefState() throws Exception {
        assertThat(shopsiteDao.findListShopIdByLanguageAndRefState(1l, 1l))
                .hasSize(1)
                .contains(2094l);
    }

    @Test
    public void testCreate() throws Exception {
        LgshopShopsite shopsite = new LgshopShopsite();
        shopsite.setActive("1");
        shopsite.setCountryId(1);
        shopsite.setCreateDate(new Date());
        shopsite.setDisplayLeguide("1");
        shopsite.setLastUpdateDate(new Date());
        shopsite.setLeadId("1");
        shopsite.setMainlanguage(1);
        shopsite.setName("shopsite2096");
        shopsite.setPublishingDate(new Date());
        shopsite.setShopState(LgshopShopStateEnum.client);
        shopsite.setSource("1");

        assertNull(shopsiteDao.findById(2095l));
        shopsiteDao.create(shopsite);
        assertNotNull(shopsite.getShopsiteId());
        assertNotNull(shopsiteDao.findById(2095l));
    }

    @Test
    public void testUpdate() throws Exception {
        String newName = "La Redoute NEW";
        LgshopShopsite shopsite = shopsiteDao.findById(2094l);
        assertEquals("La Redoute", shopsite.getName());
        shopsite.setName(newName);
        shopsiteDao.update(shopsite);
        assertEquals(newName, shopsiteDao.findById(2094l).getName());
    }

    @Test
    public void retrieveLocale_return_locale() {
        String locale = shopsiteDao.retrieveLocale(2094L);
        assertThat(locale).isEqualTo("fr_FR");
    }

    @Test
    public void createShopMapping_create_with_locale() {
        shopsiteDao.createShopMapping(1L, 2L, "laRedoutable","fr","fr_FR");
    }
}