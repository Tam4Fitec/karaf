package com.leguide.backoffice.karaf.webservices.client.engine.exception;

/**
 * @author frederic.quinet
 * 
 */
public class EngineException extends Exception {

	private static final long serialVersionUID = 6592832640103211530L;

	/**
	 * 
	 */
	public EngineException() {
	}

	/**
	 * @param message
	 */
	public EngineException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EngineException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EngineException(String message, Throwable cause) {
		super(message, cause);
	}

}
