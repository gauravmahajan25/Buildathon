package com.chooseacab.platform.exception;

/**
 * SystemMessageException.
 *
 * Wraps a SystemMessage in a RuntimeException so if an error occurs in the API
 * that requires a predefined system message to be returned, the upper layers can
 * handle it appropriately.
 *
 * @see SystemMessage
 */
public class SystemMessageException extends RuntimeException {
  private final SystemMessage systemMessage;

  /**
   * argument constructor with systemMessage.
   * @param systemMessage
   */
  public SystemMessageException(final SystemMessage systemMessage) {
    super(systemMessage.getMessage());
    this.systemMessage = systemMessage;
  }
  /**
   * argument constructor with cause and systemMessage.
   * @param cause
   * @param systemMessage
   */
  public SystemMessageException(final Throwable cause, final SystemMessage systemMessage) {
    super(systemMessage.getMessage());
    this.systemMessage = systemMessage;
    this.initCause(cause);
  }
  /**
   * get the system message.
   * @return system message
   */
  public SystemMessage getSystemMessage() {
    return systemMessage;
  }
}
