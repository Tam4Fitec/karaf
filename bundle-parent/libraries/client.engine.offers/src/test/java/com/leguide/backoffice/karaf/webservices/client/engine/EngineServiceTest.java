package com.leguide.backoffice.karaf.webservices.client.engine;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.leguide.backoffice.karaf.webservices.client.engine.EngineService;
import com.leguide.backoffice.karaf.webservices.client.engine.IEngineClient;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.RESULTATPN;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.Response;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineJaxbException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class EngineServiceTest {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(EngineServiceTest.class);

    private EngineService xmlEngineService;
    @Autowired
    private Properties testEngineProperties;

    // private String productNetResponse =
    // "C:/DEV/sources/LG_Mobile/LGMobileWS_Iphone/src/test/resources/com/leguide/mobile/engine/client/productNetResponse.xml";
    private URI productNetResponse;

    @Before
    public void setUp() throws EngineJaxbException {
        assertNotNull(testEngineProperties);
        assertNotNull(testEngineProperties.getProperty(IEngineClient.engineRequestProtocole));
        assertNotNull(testEngineProperties.getProperty(IEngineClient.engineRequestAddress));
        assertNotNull(testEngineProperties.getProperty(IEngineClient.engineRequestPort));
        xmlEngineService = new EngineService(testEngineProperties.getProperty(IEngineClient.engineRequestProtocole),
                testEngineProperties.getProperty(IEngineClient.engineRequestAddress),
                Integer.valueOf(testEngineProperties.getProperty(IEngineClient.engineRequestPort)));
    }

    @After
    public void tearDown() {
        xmlEngineService = null;
    }
    @Test
    public void testUnMarshallResultat() throws Exception {
        logger.debug("productNetResponse = [{}]", productNetResponse);
        productNetResponse = getClass().getResource("productNetResponseTest.xml").toURI();
        System.out.println("productNetResponse = " + productNetResponse);
        StringBuffer sb = new StringBuffer();
        // BufferedReader br = new BufferedReader(new FileReader(new
        // File("resultxml.xml")));
        BufferedReader br = new BufferedReader(new FileReader(new File(productNetResponse)));
        String st = null;
        while ((st = br.readLine()) != null) {
            sb.append(st);
        }
        br.close();

        // FileInputStream fis = new File(uri)

        Response result = (Response) xmlEngineService.buildResponse(sb.toString(), RESULTATPN.class);
        RESULTATPN resultatpn = (RESULTATPN) result;

        assertTrue(resultatpn.getMARKLISTCOUNT() > 0);
        assertTrue(resultatpn.getMARKLIST().getMARK().size() > 0);
        assertTrue(resultatpn.getPRICELISTCOUNT() > 0);
        assertTrue(resultatpn.getPRICELIST().getPRICE().size() > 0);
        assertTrue(resultatpn.getPOPULARCATLISTCOUNT() > 0);
        assertTrue(resultatpn.getPOPULARCATLIST().getCAT().size() > 0);
        assertTrue(resultatpn.getPRODUCTLISTCOUNT() > 0);
        assertTrue(resultatpn.getPRODUCTLIST().getPRODUCT().size() > 0);

    }

    @Test
    public void tesTMatch() {
        String resp = "TNGL�<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
        		"<RESULTAT><TOTAL_PRODUCT_COUNT>207066</TOTAL_PRODUCT_COUNT><SHOP_TOTAL_OFFRE_COUNT>207066</SHOP_TOTAL_OFFRE_COUNT>" +
        		"<SHOP_ID>14501</SHOP_ID><SHOPSITE_ID><![CDATA[86]]></SHOPSITE_ID><SHOP_NAME>" +
        		"<![CDATA[Piecesauto-Tuning]]></SHOP_NAME><SHOP_FLAG>67</SHOP_FLAG><CAT_LIST_COUNT>20</CAT_LIST_COUNT>" +
        		"<CAT_LIST><CAT PLACE=\"1\"><CAT_ID_INTERNE>2090000</CAT_ID_INTERNE><CAT_ID>2120000</CAT_ID><CAT_NAME>" +
        				"<![CDATA[Tuning]]></CAT_NAME>";
        Long res = xmlEngineService.extractIntraInfoMagTotalCount(resp);
        assertEquals(Long.valueOf(207066l), res);
    }
}
