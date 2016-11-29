package com.chooseacab.platform.exception;

/**
 * Represents a no entity found.
 */
public class NoSuchEntityException extends RuntimeException {
	/**
	 * default constructor
	 */
    public NoSuchEntityException() {
    	//default constructor
    }
    /**
     * argument constructor with message
     * @param message
     */
    public NoSuchEntityException(final String message) {
        super(message);
    }
}
