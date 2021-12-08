package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.jaxb.helpers;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.helpers.DefaultValidationEventHandler;

public class BrandsListValidationEventHandler extends DefaultValidationEventHandler {

    @Override
    public boolean handleEvent(ValidationEvent event) {
        if (event.getSeverity() == ValidationEvent.WARNING) {
            return super.handleEvent(event);
        } else {
            throw new RuntimeException(event.getMessage() + " [line:" + event.getLocator().getLineNumber()
                    + ", column:" + event.getLocator().getColumnNumber() + "]");
        }
    }
}
