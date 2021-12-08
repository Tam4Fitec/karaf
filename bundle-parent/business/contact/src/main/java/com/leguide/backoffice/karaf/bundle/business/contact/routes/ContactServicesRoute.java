package com.leguide.backoffice.karaf.bundle.business.contact.routes;

import com.leguide.backoffice.karaf.business.models.pojo.contact.Contact;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;

public class ContactServicesRoute extends RouteBuilder {

    @Value("${leguide.endpoint.jms.contact.delete}")
    private String fromContactDeleteEndpoint;

    @Override
    public void configure() {

        onException(Exception.class)
                .log(LoggingLevel.ERROR, "com.leguide.backoffice.karaf.bundle.business.contact.routes", "An exception occured during the treatement of the event of contact  : ${exception.message}, stackTrace : ${exception.stacktrace}")
                .logStackTrace(true)
                .handled(true)
                .end();

        from(fromContactDeleteEndpoint).routeId("deleteContactServiceRoute")
                .log(LoggingLevel.INFO, "com.leguide.backoffice.karaf.bundle.business.contact.routes", "Delete contact...")
                .log(LoggingLevel.INFO, "com.leguide.backoffice.karaf.bundle.business.contact.routes", "Body = ${body}")
                .unmarshal().json(JsonLibrary.Jackson, Contact.class)
                .log(LoggingLevel.DEBUG, "com.leguide.backoffice.karaf.bundle.business.contact.routes", "After unmarshall Contact")
                .beanRef("contactServiceImpl", "deleteContactFromJms")
                .log(LoggingLevel.INFO, "com.leguide.backoffice.karaf.bundle.business.contact.routes", "After delete Contact ")
                .end();
    }

}
