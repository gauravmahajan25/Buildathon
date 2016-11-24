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

  public BadRequestException(SystemMessage systemMessage) {
    super(systemMessage);
  }

  public BadRequestException(Throwable cause, SystemMessage systemMessage) {
    super(cause, systemMessage);
  }
}
