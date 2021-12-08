package com.leguide.backoffice.karaf.brands.common.exception;

public class BadRequestException extends AbstractBusinessException {

    private static final long serialVersionUID = -109188653125585388L;

    private ErrorCodes errcode = ErrorCodes.ERR000;

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }
    
    public BadRequestException(ErrorCodes error) {
        super();
        this.errcode = error;
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public ErrorCodes getErrcode() {
        return errcode;
    }

}
