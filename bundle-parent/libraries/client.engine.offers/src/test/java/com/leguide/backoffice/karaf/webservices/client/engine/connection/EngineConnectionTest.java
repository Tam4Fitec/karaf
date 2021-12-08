package com.leguide.backoffice.karaf.webservices.client.engine.connection;

import com.leguide.backoffice.karaf.webservices.client.engine.IEngineClient;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.request.ListOffersRequest;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineConnectionException;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.JAXBContext;

import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class EngineConnectionTest {

    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(EngineConnectionTest.class);

    private EngineConnection engineConnection;
    @Autowired
    private Properties testEngineProperties;

    @Before
    public void setUp() {
        assertNotNull(testEngineProperties);
        assertNotNull(testEngineProperties.getProperty(IEngineClient.engineRequestAddress));
        assertNotNull(testEngineProperties.getProperty(IEngineClient.engineRequestPort));
        engineConnection = new EngineConnection(testEngineProperties.getProperty(IEngineClient.engineRequestAddress),
                Integer.valueOf(testEngineProperties.getProperty(IEngineClient.engineRequestPort)));
    }

    @After
    public void tearDown() throws EngineConnectionException {
        engineConnection = null;
    }

    @Test
    public void testEngineConnection() throws Exception {
        try {
            engineConnection.connect();
            OutputStream os = engineConnection.getOutputStream();
            assertNotNull(os);

        } finally {
            engineConnection.disconnect();
        }

    }

    @Test(expected = EngineConnectionException.class)
    public void testEngineConnectionWithError() throws Exception {

        engineConnection.setHost("127.0.0.1");
        engineConnection.connect();
        engineConnection.disconnect();
        fail();

    }

    @Test
    public void testMarshallQuery() throws Exception {

        ListOffersRequest request = new ListOffersRequest();
        request.setKFunc("Liste_offres");
        request.setKPays("FR");
        request.setKZone(1);
        request.setKSite(1);
        request.setKBaseID(55815517);
        request.setKOccasion(1);
        request.setKProdCount(30);
        request.setKPage(0);
        request.setKSort(176);
        request.setKGroup(1);
        request.setKDiscountMin(0);
        request.setKDiscountMax(100);
        request.setKPhp(0);
        try {
            JAXBContext context = JAXBContext.newInstance(ListOffersRequest.class);

            String marshalledQuery = engineConnection.marshallQuery(request, context);
            URL uri = this.getClass().getResource("/com/leguide/backoffice/karaf/webservices/client/engine/listOffersRequest.xml");
            String fileInput = FileUtils.readFileToString(new File(uri.toURI()));

            Assert.assertEquals(fileInput, marshalledQuery);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
