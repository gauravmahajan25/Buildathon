package com.chooseacab.platform.exception;

/**
 * BadRequestException
 *
 * Represents a SystemMessage that was caused by a "bad request" meaning
 * some sort of illegal argument exception perhaps.
 *
 * @see SystemMessage
 * @see SystemMessageException
 */
public class BadRequestException extends SystemMessageException {
  
  /**
   * argument constructor with systemMessage
   * @param systemMessage
   */
  public BadRequestException(final SystemMessage systemMessage) {
    super(systemMessage);
  }
  /**
   * argument constructor with cause and systemMessage
   * @param cause
   * @param systemMessage
   */
  public BadRequestException(final Throwable cause, final SystemMessage systemMessage) {
    super(cause, systemMessage);
  }
}
