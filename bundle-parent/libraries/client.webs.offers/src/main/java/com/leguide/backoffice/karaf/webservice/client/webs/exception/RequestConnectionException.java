package com.leguide.backoffice.karaf.webservice.client.webs.exception;

/*
 * Created by stephane.ben-zakoun on 24/05/17.
 */
public class RequestConnectionException extends Exception {

    public RequestConnectionException(String message) {
        super(message);
    }

    public RequestConnectionException(Throwable cause) {
        super(cause);
    }

}
