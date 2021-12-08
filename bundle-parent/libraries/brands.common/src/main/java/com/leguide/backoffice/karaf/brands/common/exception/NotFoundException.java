package com.leguide.backoffice.karaf.brands.common.exception;

/**
 * Exception thrown if brands lookup returns zero element.
 * 
 * @author cbaudoin
 * 
 */
public class NotFoundException extends AbstractBusinessException {

    private static final long serialVersionUID = -2645830005035789453L;

    public NotFoundException() {
        super("no results for given parameters");
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
