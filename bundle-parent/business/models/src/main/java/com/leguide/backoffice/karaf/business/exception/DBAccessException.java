package com.leguide.backoffice.karaf.business.exception;

/**
 * Generic exception to throw in case of error when accessing a DB. Should not be used to manage an empty result
 * @author jlboulanger
 *
 */
public class DBAccessException extends RuntimeException {

    private static final long serialVersionUID = -3588121123290131754L;

    public DBAccessException() {
    }

    public DBAccessException(String message) {
        super(message);
    }

    public DBAccessException(Throwable cause) {
        super(cause);
    }

    public DBAccessException(String message, Throwable cause) {
        super(message, cause);
    }

}
