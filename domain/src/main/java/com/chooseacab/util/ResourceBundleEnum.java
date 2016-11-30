package com.chooseacab.util;

import java.util.HashMap;
import java.util.Map;

/** 
 * Resource Bundle Enum. 
 */
public enum ResourceBundleEnum {
  DEFAULT("default"),

  NOT_FOUND("not.found")
  ;

  private static final Map<String, ResourceBundleEnum> resourceBundleEnumsByMessageId = new HashMap<>(ResourceBundleEnum.values().length);

  /**
   * Static block to initialize resource bundle messages.
   */
  static {
    for (ResourceBundleEnum e : ResourceBundleEnum.values()) {
      resourceBundleEnumsByMessageId.put(e.getMessageId(), e);
    }
  }

  /**
   * Property for message id.
   */
  private final String messageId;

  /**
   * Initialize message id.
   * @param messageId - messageId.
   */
  ResourceBundleEnum(final String messageId) {
    this.messageId = messageId;
  }

  /**
   * Get message id.
   * @return String - messageId.
   */
  public String getMessageId() {
    return this.messageId;
  }
  
  /**
   * Get Resource Bundle Enum for a message id.
   * @param messageId.
   * @return ResourceBundleEnum - resourcebundleEnum.
   */
  public static ResourceBundleEnum fromMessageId(final String messageId) {
    ResourceBundleEnum resourceBundleEnum = resourceBundleEnumsByMessageId.get(messageId);
    if (resourceBundleEnum == null) {
      throw new IllegalArgumentException("No ResourceBundleEnum exists with message ID: " + messageId);
    }
    return resourceBundleEnum;
  }
}
