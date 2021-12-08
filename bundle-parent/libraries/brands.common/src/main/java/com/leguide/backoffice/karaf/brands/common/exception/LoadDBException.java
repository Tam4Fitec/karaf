package com.leguide.backoffice.karaf.brands.common.exception;

/**
 * Exception thrown if brands lookup returns zero element.
 * 
 * @author cbaudoin
 * 
 */
public class LoadDBException extends AbstractBusinessException {

    private static final long serialVersionUID = -2645830005035789453L;

    private ErrorCodes err = ErrorCodes.ERR005;
    
    public LoadDBException() {
        super("load failed");
    }

    public LoadDBException(String message) {
        super(message);
    }

    public LoadDBException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoadDBException(Throwable cause) {
        super(cause);
    }

    public ErrorCodes getErr() {
        return err;
    }

    public void setErr(ErrorCodes err) {
        this.err = err;
    }
}
