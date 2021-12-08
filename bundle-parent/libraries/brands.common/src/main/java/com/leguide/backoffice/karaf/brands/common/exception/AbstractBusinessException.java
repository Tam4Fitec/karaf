package com.leguide.backoffice.karaf.brands.common.exception;

public abstract class AbstractBusinessException extends RuntimeException {

    private static final long serialVersionUID = 2953405211595911106L;

    public AbstractBusinessException() {
        super();
    }

    public AbstractBusinessException(String message) {
        super(message);
    }

    public AbstractBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractBusinessException(Throwable cause) {
        super(cause);
    }
}
