package com.leguide.backoffice.karaf.webservices.wsbrands.api.exception;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class representing an xml output in case of exception
 * @author jlboulanger
 *
 */
@XmlRootElement(name = "error")
public class WSExceptionOutput {

    @XmlAttribute(name = "type")
    private String type;

    @XmlElement(name = "message")
    private String message;

    public WSExceptionOutput(String e, String msg) {
        type = e;
        message = msg;
    }

    public WSExceptionOutput() {
        super();
    }
}
