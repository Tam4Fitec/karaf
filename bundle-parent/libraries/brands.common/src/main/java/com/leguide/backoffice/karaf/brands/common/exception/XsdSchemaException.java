package com.leguide.backoffice.karaf.brands.common.exception;

public class XsdSchemaException extends RuntimeException {

    private static final long serialVersionUID = -5665595372422028851L;

    public XsdSchemaException() {
        super();
    }

    public XsdSchemaException(String message) {
        super(message);
    }

    public XsdSchemaException(String message, Throwable cause) {
        super(message, cause);
    }

    public XsdSchemaException(Throwable cause) {
        super(cause);
    }
}
