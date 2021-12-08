package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.jaxb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.jaxb.helpers.BrandsListValidationEventHandler;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandInWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandsListInWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.ObjectFactory;

public class JaxbTest {

    @Test
    public void testBrandsList() throws Exception {
        BrandsListInWrapper brandsList = createJaxbBrandsList();

        String xmlDocument = marshallBrandsListToXml(brandsList);
        System.out.println(xmlDocument);
        assertTrue(xmlDocument.contains("<name>my_brand</name>"));
        assertTrue(xmlDocument.contains("activationDate=\"2012-02-10\""));

        BrandsListInWrapper unmarshalledBrandsList = unmarshallToBrandsListFromXml(xmlDocument);
        assertEquals(1, unmarshalledBrandsList.getBrand().size());
    }

    @Test
    public void testUnMarshallBrandList() throws JAXBException, SAXException {

        String xmlDocument = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><brandsList><brand activationDate=\"2010-05-05\"><name>my_brand</name></brand></brandsList>";
        BrandsListInWrapper unmarshalledBrandsList = unmarshallToBrandsListFromXml(xmlDocument);
        assertEquals(1, unmarshalledBrandsList.getBrand().size());
        assertEquals("my_brand", unmarshalledBrandsList.getBrand().get(0).getName());
    }

    @Test(expected = JAXBException.class)
    public void testUnmarshallValidation() throws JAXBException, SAXException {

        String xmlDocument = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><brandsList><test></test><brand activationDate=\"2010-10-05\"><name>my_brand</name></brand></brandsList>";
        unmarshallToBrandsListFromXml(xmlDocument);
    }

    @Test(expected = RuntimeException.class)
    public void testUnmarshallDateValidation() throws JAXBException, SAXException {

        String xmlDocument = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><brandsList><brand activationDate=\"2010-16-05\"><name>my_brand</name></brand></brandsList>";
        unmarshallToBrandsListFromXml(xmlDocument);
    }

    @Test
    public void testUnmarshallDatesValidation() throws JAXBException, SAXException {

        String xmlDocument = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><brandsList><brand activationDate=\"2010-16-05\"><name>my_brand</name></brand><brand activationDate=\"2010-10-35\"><name>my_brand2</name></brand></brandsList>";

        // Initializing validation event handler
        // Here we want to get all error messages when unmarshalling the xml
        ValidationEventCollector vec = new ValidationEventCollector();

        unmarshallToBrandsListFromXml(xmlDocument, vec);

        if (vec.hasEvents()) {
            ValidationEvent[] events = vec.getEvents();
            for (int i = 0; i < events.length; i++) {
                ValidationEvent event = events[i];
                System.out.println(event.getMessage() + " [line:" + event.getLocator().getLineNumber() + ", column:"
                        + event.getLocator().getColumnNumber() + "]");
            }
        }

        assertTrue(vec.hasEvents());
        assertEquals(2, vec.getEvents().length);
    }

    /**
     * 
     * @param xmlDocument
     * @param eventHandler
     * @return
     * @throws JAXBException
     * @throws SAXException
     */
    private BrandsListInWrapper unmarshallToBrandsListFromXml(String xmlDocument, ValidationEventHandler eventHandler)
            throws JAXBException, SAXException {

        JAXBContext context = JAXBContext.newInstance(BrandsListInWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xmlDocument);

        unmarshaller.setSchema(this.getValidationSchema());

        unmarshaller.setEventHandler(eventHandler);

        BrandsListInWrapper unmarshalledBrandsList = (BrandsListInWrapper) unmarshaller.unmarshal(reader);

        return unmarshalledBrandsList;
    }

    /**
     * 
     * @param xmlDocument
     * @return
     * @throws JAXBException
     * @throws SAXException
     */
    private BrandsListInWrapper unmarshallToBrandsListFromXml(String xmlDocument) throws JAXBException, SAXException {

        return this.unmarshallToBrandsListFromXml(xmlDocument, new BrandsListValidationEventHandler());
    }

    /**
     * 
     * @return
     * @throws SAXException
     */
    private Schema getValidationSchema() throws SAXException {
        File schemaFile = new File("src/main/resources/brand_list.xsd");
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        return schemaFactory.newSchema(schemaFile);
    }

    private BrandsListInWrapper createJaxbBrandsList() throws DatatypeConfigurationException {

        BrandsListInWrapper brandsList = new ObjectFactory().createBrandsList();

        BrandInWrapper brand = new BrandInWrapper();
        brand.setName("my_brand");
        brand.setActivationDate(new Date(1328883991000L)); // 2012-02-10

        brandsList.getBrand().add(brand);

        return brandsList;
    }

    public String marshallBrandsListToXml(BrandsListInWrapper brandsList) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(BrandsListInWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.marshal(brandsList, writer);

        return writer.toString();
    }
}
