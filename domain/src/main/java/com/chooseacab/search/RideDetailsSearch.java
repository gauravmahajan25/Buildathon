package com.chooseacab.search;

import java.util.Set;

public class RideDetailsSearch {

  private final Long sourceId;
  private final Long destinationId;
  private final Set<Long> operatorIds;
  private final Set<Long> typeIds;

  public RideDetailsSearch(final Long sourceId,
                           final Long destinationId,
                           final Set<Long> operatorIds,
                           final Set<Long> typeIds) {
    this.sourceId = sourceId;
    this.destinationId = destinationId;
    this.operatorIds = operatorIds;
    this.typeIds = typeIds;
  }

  public Long getSourceId() {
    return sourceId;
  }

  public Long getDestinationId() {
    return destinationId;
  }

  public Set<Long> getOperatorIds() {
    return operatorIds;
  }

  public Set<Long> getTypeIds() {
    return typeIds;
  }
}
