package com.chooseacab.util;

import java.util.HashMap;
import java.util.Map;

public enum ResourceBundleEnum {
  DEFAULT("default"),

  NOT_FOUND("not.found")
  ;

  private static final Map<String, ResourceBundleEnum> resourceBundleEnumsByMessageId = new HashMap<>(ResourceBundleEnum.values().length);

  static {
    for (ResourceBundleEnum e : ResourceBundleEnum.values()) {
      resourceBundleEnumsByMessageId.put(e.getMessageId(), e);
    }
  }

  private final String messageId;

  ResourceBundleEnum(String messageId) {
    this.messageId = messageId;
  }

  public String getMessageId() {
    return this.messageId;
  }

  public static ResourceBundleEnum fromMessageId(String messageId) {
    ResourceBundleEnum resourceBundleEnum = resourceBundleEnumsByMessageId.get(messageId);
    if (resourceBundleEnum == null) {
      throw new IllegalArgumentException("No ResourceBundleEnum exists with message ID: " + messageId);
    }
    return resourceBundleEnum;
  }
}
