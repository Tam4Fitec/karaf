package com.leguide.backoffice.karaf.brands.common.exception;

public class UnmarshallingException extends AbstractBusinessException {

    private static final long serialVersionUID = -5020984138515978282L;

    public UnmarshallingException() {
        super();
    }

    public UnmarshallingException(String message) {
        super(message);
    }

    public UnmarshallingException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnmarshallingException(Throwable cause) {
        super(cause);
    }
}
