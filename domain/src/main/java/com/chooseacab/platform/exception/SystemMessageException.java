package com.chooseacab.platform.exception;

/**
 * SystemMessageException
 *
 * Wraps a SystemMessage in a RuntimeException so if an error occurs in the API
 * that requires a predefined system message to be returned, the upper layers can
 * handle it appropriately.
 *
 * @see SystemMessage
 */
public class SystemMessageException extends RuntimeException {
  private final SystemMessage systemMessage;

  public SystemMessageException(SystemMessage systemMessage) {
    super(systemMessage.getMessage());
    this.systemMessage = systemMessage;
  }

  public SystemMessageException(Throwable cause, SystemMessage systemMessage) {
    super(systemMessage.getMessage());
    this.systemMessage = systemMessage;
    this.initCause(cause);
  }

  public SystemMessage getSystemMessage() {
    return systemMessage;
  }
}
