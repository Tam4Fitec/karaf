package com.leguide.backoffice.karaf.webservices.client.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.RESULTATPI;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.RESULTATPN;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineJaxbException;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineRequestParameterException;
import com.leguide.backoffice.karaf.webservices.client.engine.factory.IEngineClientFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
@Ignore
public class EngineClientTest {

    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(EngineClientTest.class);

    private IEngineClient client;
    @Autowired
    private Properties testEngineProperties;

    //expected values from properties
    private String expectedlanguage="FR";
    private String expectedsite="2";
    private String expecteddeliveryZone="1";
    private String expectedmarksNumber="100";
    private String expectedshortLinksNumber="20";
    private String expectedprotocole="1.1";
    private String expectedaddress="192.168.0.27";
    private String expectedport="12560";
    private String expectedsortTypeProductNet="45056";
    private String expectedsortTypeListOffre="32768";
    private String expectedcatCount="25";
    private String expectedshortReviewsSources = null;

    @Before
    public void setUp() {
        assertNotNull(testEngineProperties);
        assertEquals(expectedlanguage, testEngineProperties.getProperty(IEngineClient.engineRequestLanguage));
        assertEquals(expectedsite, testEngineProperties.getProperty(IEngineClient.engineRequestSite));
        assertEquals(expecteddeliveryZone, testEngineProperties.getProperty(IEngineClient.engineRequestDeliveryZone));
        assertEquals(expectedmarksNumber, testEngineProperties.getProperty(IEngineClient.engineRequestMarksNumber));
        assertEquals(expectedshortLinksNumber, testEngineProperties.getProperty(IEngineClient.engineRequestShortLinksNumber));
        assertEquals(expectedprotocole, testEngineProperties.getProperty(IEngineClient.engineRequestProtocole));
        assertEquals(expectedaddress, testEngineProperties.getProperty(IEngineClient.engineRequestAddress));
        assertEquals(expectedport, testEngineProperties.getProperty(IEngineClient.engineRequestPort));
        assertEquals(expectedsortTypeProductNet, testEngineProperties.getProperty(IEngineClient.engineRequestSortTypeProductNet));
        assertEquals(expectedsortTypeListOffre, testEngineProperties.getProperty(IEngineClient.engineRequestSortTypeListOffre));
        assertEquals(expectedcatCount, testEngineProperties.getProperty(IEngineClient.engineRequestCatCount));
        assertEquals(expectedshortReviewsSources, testEngineProperties.getProperty(IEngineClient.engineRequestShortReviewsSources));
    }

    @After
    public void tearDown() {
        client = null;
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testMissingParameter01() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.remove(IEngineClient.engineRequestLanguage);
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testMissingParameter02() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.remove(IEngineClient.engineRequestSite);
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testMissingParameter03() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.remove(IEngineClient.engineRequestDeliveryZone);
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testMissingParameter04() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.remove(IEngineClient.engineRequestMarksNumber);
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testMissingParameter05() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.remove(IEngineClient.engineRequestShortLinksNumber);
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testMissingParameter06() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.remove(IEngineClient.engineRequestProtocole);
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testMissingParameter07() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.remove(IEngineClient.engineRequestAddress);
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testMissingParameter08() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.remove(IEngineClient.engineRequestPort);
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testMissingParameter09() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.remove(IEngineClient.engineRequestSortTypeProductNet);
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testMissingParameter10() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.remove(IEngineClient.engineRequestSortTypeListOffre);
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testMissingParameter11() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.remove(IEngineClient.engineRequestCatCount);
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testNumberFormatParameter01() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.put(IEngineClient.engineRequestCatCount, "a");
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testNumberFormatParameter02() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.put(IEngineClient.engineRequestSortTypeListOffre, "a");
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testNumberFormatParameter03() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.put(IEngineClient.engineRequestSortTypeProductNet, "a");
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testNumberFormatParameter04() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.put(IEngineClient.engineRequestPort, "a");
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testNumberFormatParameter05() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.put(IEngineClient.engineRequestShortLinksNumber, "a");
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testNumberFormatParameter06() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.put(IEngineClient.engineRequestMarksNumber, "a");
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testNumberFormatParameter07() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.put(IEngineClient.engineRequestDeliveryZone, "a");
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testNumberFormatParameter08() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.put(IEngineClient.engineRequestSite, "a");
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testNumberFormatParameter09() throws EngineRequestParameterException, EngineJaxbException {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.setProperty(IEngineClient.engineRequestShortReviewsSources, "a");
        client = IEngineClientFactory.getInstance(tmp);
        fail();
    }

    //test findOffersByProductId
    @Test
    @Ignore //the product id may disapear the test is not relevant
    public void testfindOffersByProductId() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.findOffersByProductId(70139396l, 20, 1, -1, 100, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }

    @Test
    @Ignore //the product id may disapear the test is not relevant
    public void testfindOffersByProductIdWithShortReviewsSources() throws Exception {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.setProperty(IEngineClient.engineRequestShortReviewsSources, "15");
        client = IEngineClientFactory.getInstance(tmp);
        EngineResponse engineResponse = client.findOffersByProductId(70139396L, 20, 1, -1, 100, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }

    @Test(expected=EngineRequestParameterException.class)
    public void testfindOffersByProductIdMissingProdId() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.findOffersByProductId(null, 20, 1, -1, 100, true, true);
        fail();
    }
    @Test(expected=EngineRequestParameterException.class)
    public void testfindOffersByProductIdMissingPageNum() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.findOffersByProductId(55815517L, 20, null, -1, 100, true, true);
        fail();
    }
    @Test(expected=EngineRequestParameterException.class)
    public void testfindOffersByProductIdPageNum0() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.findOffersByProductId(55815517L, 20, 0, -1, 100, true, true);
        fail();
    }

    //productsNet
    @Test
    public void testProductNet() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.productsNet(3030100l, "livre", null, null, null, new Float(100),
                20, 1, -1, 100, true, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }

    @Test
    public void testListOffresStoreId() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.listOffresByStoreId(28008386l, 5, 1, -1, 100, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }

    @Test
    public void testListOffresStoreIdWithDebug() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.listOffresByStoreIdWithDebug(28008386l, 5, 1, -1, 100, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
        assertTrue(resultat.getPRODUCTLIST().getPRODUCT().get(0).getDebug().getDbgProdClic() >= 0);
    }

    @Test
    public void testProductNetWithShortReviewsSources() throws Exception {
        Properties tmp = new Properties();
        tmp.putAll(testEngineProperties);
        tmp.setProperty(IEngineClient.engineRequestShortReviewsSources, "15");
        client = IEngineClientFactory.getInstance(tmp);
        EngineResponse engineResponse = client.productsNet(3030100l, "livre", null, null, null, new Float(100),
                5, 1, -1, 100, true, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }
    @Test(expected=EngineRequestParameterException.class)
    public void testProductNetPageNum0() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.productsNet(3030100l, "livre", null, null, null, new Float(10), 20, 0, -1, 100, true, true, true);
        fail();
    }
    @Test(expected=EngineRequestParameterException.class)
    public void testProductNetMissingPageNum() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.productsNet(3030100l, "livre", null, null, null, new Float(10), 20, null, -1, 100, true, true, true);
        fail();
    }

    //getMarks
    @Test
    public void testGetMarks() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.getMarks(3030100l, null, "Hachette", null, null, new Float(100),
                -1, 100, true, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }

    //getPrices
    @Test
    public void testGetPrices() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.getPrices(3030100l, null, "Hachette", null, null, new Float(100),
                20, 1, -1, 100, true, true, false);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }
    @Test(expected=EngineRequestParameterException.class)
    public void testGetPricesPageNum0() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.getPrices(3030100l, null, "Hachette", null, null, new Float(10),20, 0, -1, 100, true, true, true);
        fail();
    }
    @Test(expected=EngineRequestParameterException.class)
    public void testGetPricesMissingPageNum() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.getPrices(3030100l, null, "Hachette", null, null, new Float(10), 20, null, -1, 100, true, true, true);
        fail();
    }

    //findAttributesWithProductId
    @Test
    @Ignore //the product id may disapearn the test is not relevant
    public void testFindAttributesWithProductId() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.findAttributesWithProductId(58709015L, 20, 1, -1, 100, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }
    @Test(expected=EngineRequestParameterException.class)
    public void testFindAttributesWithProductIdMissingProdId() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.findAttributesWithProductId(null, 20, 1, -1, 100, true, true);
        fail();
    }
    @Test(expected=EngineRequestParameterException.class)
    public void testFindAttributesWithProductIdMissingPageNum() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.findAttributesWithProductId(55815517L, 20, null, -1, 100, true, true);
        fail();
    }
    @Test(expected=EngineRequestParameterException.class)
    public void testFindAttributesWithProductIdPageNum0() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.findAttributesWithProductId(55815517L, 20, 0, -1, 100, true, true);
        fail();
    }

    //findProdInfoByProductId
    @Test
    @Ignore
    public void testFindProdInfoByProductId() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.findProdInfoByProductId("00000579148368");
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPI resultat = (RESULTATPI) engineResponse.getResponse();
        assertNotNull(resultat);
        assertNotNull(resultat.getPRODUCT());
    }

    //findOffersWithBarCode
    @Test
    public void testFindOffersWithBarCode() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.findOffersWithBarCode("ipad blanc", 1, 1, -1, 100, false, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }
    @Test(expected=EngineRequestParameterException.class)
    public void testFindOffersWithBarCodeMissingPageNum() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.findOffersWithBarCode("ipad blanc", 1, null, -1, 100, false, true, true);
        fail();
    }
    @Test(expected=EngineRequestParameterException.class)
    public void testFindOffersWithBarCodePageNum0() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        client.findOffersWithBarCode("ipad blanc", 1, 0, -1, 100, false, true, true);
        fail();
    }

    //getPopCats
    @Test
    public void testGetPopCats() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.getPopCats(null, null, "Hachette", null, new Float(10),
                10, -1, 100, true, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }

    //getCriteria
    @Test
    public void testGetCriteria() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.getCriteria(null, null, "Hachette", null, new Float(10),
                -1, 100, true, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }

    //getFilters
    @Test
    public void testGetFilters() throws Exception {
        client = IEngineClientFactory.getInstance(testEngineProperties);
        EngineResponse engineResponse = client.getFilters(null, null, "Hachette", null, new Float(10), "",
                10, -1, 100, true, true, true);
        assertNotNull(engineResponse);
        engineResponse.getResponse();
        RESULTATPN resultat = (RESULTATPN) engineResponse.getResponse();
        assertNotNull(resultat);
        assertTrue(resultat.getPRODUCTCOUNT() >= 1);
    }
}
