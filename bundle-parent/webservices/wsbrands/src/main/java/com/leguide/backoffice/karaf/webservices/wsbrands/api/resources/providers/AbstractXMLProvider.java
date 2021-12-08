package com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.providers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;

import com.leguide.backoffice.karaf.brands.common.exception.BadRequestException;
import com.leguide.backoffice.karaf.brands.common.exception.UnmarshallingException;
import com.leguide.backoffice.karaf.brands.common.exception.XsdSchemaException;

@Provider
@Component
@Consumes(MediaType.APPLICATION_XML)
public abstract class AbstractXMLProvider<T> implements MessageBodyReader<T> {

    @Context
    protected Providers providers;

    private static Logger logger = LoggerFactory.getLogger(AbstractXMLProvider.class);

    public AbstractXMLProvider() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {

        Class<T> readableClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        return arg0 == readableClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T readFrom(Class<T> arg0, Type arg1, Annotation[] arg2, MediaType arg3, MultivaluedMap<String, String> arg4,
            InputStream arg5) throws IOException, WebApplicationException {

        try {
            JAXBContext jaxbContext = null;
            ContextResolver<JAXBContext> resolver = this.providers.getContextResolver(JAXBContext.class, arg3);
            if (null != resolver) {
                jaxbContext = resolver.getContext(arg0);
            }
            if (null == jaxbContext) {
                jaxbContext = JAXBContext.newInstance(arg0);
            }

            ValidationEventCollector vec = new ValidationEventCollector();

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.setSchema(this.loadSchema());
            unmarshaller.setEventHandler(vec);

            T list = (T) unmarshaller.unmarshal(arg5);

            // Logging all the errors found when parsing the XML file
            if (vec.hasEvents()) {
                ValidationEvent[] events = vec.getEvents();
                StringBuilder mes = new StringBuilder();
                for (int i = 0; i < events.length; i++) {
                    ValidationEvent event = events[i];
                    String error = event.getMessage() + " [line:" + event.getLocator().getLineNumber() + ", column:"
                            + event.getLocator().getColumnNumber() + "]. ";
                    logger.info(error);
                    mes.append(error);
                }
                throw new UnmarshallingException(mes.toString());
            }

            return list;
        } catch (UnmarshallingException e) {
            throw new BadRequestException(e);
        } catch (JAXBException e) {
            throw new BadRequestException(new UnmarshallingException(e));
        }
    }

    /**
     * Load XSD schema file.
     * 
     * @return Schema XSD schema.
     * @throws XsdSchemaException if the schema could not be loaded.
     */
    public Schema loadSchema() {
        try {
            // Preparing the XML file as a SAX source
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(this.getSchemaName());
            SAXSource source = new SAXSource(new InputSource(in));

            // Loading the schema
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            return schemaFactory.newSchema(source);
        } catch (Exception e) {
            throw new XsdSchemaException(e);
        }
    }

    /**
     * Get The XSD file name.
     * 
     * @return XSD file name
     */
    abstract public String getSchemaName();
}
