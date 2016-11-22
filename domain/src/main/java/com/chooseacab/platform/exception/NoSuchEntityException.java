package com.chooseacab.platform.exception;

/**
 * Represents a no entity found.
 */
public class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException() {

    }
    public NoSuchEntityException(String message) {
        super(message);
    }
}
