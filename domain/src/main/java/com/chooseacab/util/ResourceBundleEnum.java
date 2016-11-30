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

  private static final Map<String, ResourceBundleEnum> ResourceBundleEnumsByMessageId = new HashMap<>(ResourceBundleEnum.values().length);

  /**
   * Static block to initialize resource bundle messages.
   */
  static {
    for (ResourceBundleEnum e : ResourceBundleEnum.values()) {
      ResourceBundleEnumsByMessageId.put(e.getMessageId(), e);
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
}
