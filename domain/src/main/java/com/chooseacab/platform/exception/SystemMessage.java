package com.chooseacab.platform.exception;

import com.chooseacab.util.ResourceBundleEnum;

import org.springframework.context.MessageSource;
/**
 * Format the message for exception. 
 *
 */
public class SystemMessage {

  private final String id;
  private final String code;
  private final String message;
  
  /**
   * argument constructor with id, code and message.
   * @param id id to be shown
   * @param code code to be shown
   * @param message message to be shown
   */
  public SystemMessage(final String id, final String code, final String message) {
    this.id = id;
    this.code = code;
    this.message = message;
  }
  
  /**
   * argument constructor with message.
   * @param message message to be shown
   */
  public SystemMessage(final String message) {
    this.id = null;
    this.code = null;
    this.message = message;
  }

  /**
   * Will create a SystemMessage using the ResourceBundleEnum whose name matches the messageEnumName given.
   * If no match is found, the messageEnumName String will be used as the message text to create a new SystemMessage with a null ID and code.
   *
   * @param messageSource A MessageSource that contains the mappings of messages.
   * @param messageEnumName Either a valid name of a ResourceBundleEnum or just a String message.  If null, the ResourceBundleEnum.DEFAULT will be used to create the SystemMessage.
   * @param messageParams An array of Strings that will be filled in for params within the message.
   * @return A SystemMessage object with the ID, code, and text set based on the rules defined above.
   */
  public static SystemMessage createSystemMessage(final MessageSource messageSource, final String messageEnumName, final String... messageParams) {
    if (messageEnumName == null) {
      return createSystemMessage(messageSource, ResourceBundleEnum.DEFAULT, messageParams);
    }

    try {
      return createSystemMessage(messageSource, ResourceBundleEnum.valueOf(messageEnumName), messageParams);
    } catch (IllegalArgumentException iae) {
      return new SystemMessage(messageEnumName);
    }
  }

  /**
   * Will create a SystemMessage using the ResourceBundleEnum given.
   *
   * @param messageSource A MessageSource that contains the mappings of messages.
   * @param messageEnum A valid ResourceBundleEnum.  If null the SystemMessage will be created using ResourceBundleEnum.DEFAULT.
   * @param messageParams An array of Strings that will be filled in for params within the message.
   * @return A SystemMessage object with the ID, code, and text set based on the given ResourceBundleEnum.
   */
  public static SystemMessage createSystemMessage(final MessageSource messageSource, final ResourceBundleEnum messageEnum, final String... messageParams) {	  
    if (messageEnum == null) {
      return createSystemMessage(messageSource, ResourceBundleEnum.DEFAULT);
    }

    return new SystemMessage(messageEnum.getMessageId(),
                             messageEnum.name(),
                             messageSource.getMessage(messageEnum.getMessageId(),
                                                      messageParams,
                                                      ResourceBundleEnum.DEFAULT.getMessageId(),
                                                      null));
  }
  /**
   * get the id.
   * @return id
   */
  public String getId() {
    return id;
  }
  /**
   * get the code.
   * @return code
   */
  public String getCode() {
    return code;
  }
  /**
   * get the message.
   * @return message
   */
  public String getMessage() {
    return message;
  }

}
