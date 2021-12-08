package com.leguide.backoffice.karaf.brands.common.exception;

public class NormalizerException extends AbstractBusinessException {

    private static final long serialVersionUID = -6365304866895209481L;

    public NormalizerException() {
        super();
    }

    public NormalizerException(String message) {
        super(message);
    }

    public NormalizerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NormalizerException(Throwable cause) {
        super(cause);
    }
}
