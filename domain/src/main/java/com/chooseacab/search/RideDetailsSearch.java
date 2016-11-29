package com.chooseacab.search;

import java.util.Set;

/**
 * Class for retrieving the dependent Ids needed to generate Ride Details Report.
 * 
 */

public class RideDetailsSearch {

  private final Long sourceId;
  private final Long destinationId;
  private final Set<Long> operatorIds;
  private final Set<Long> typeIds;

  /**
   * Constructor to initialize the depended ids.
   * 
   * @param sourceId - Source Location Id
   * @param destinationId - Destination Location Id 
   * @param operatorIds - Set of Operator Ids
   * @param typeIds - Set of Type Ids
   */
  public RideDetailsSearch(final Long sourceId,
                           final Long destinationId,
                           final Set<Long> operatorIds,
                           final Set<Long> typeIds) {
    this.sourceId = sourceId;
    this.destinationId = destinationId;
    this.operatorIds = operatorIds;
    this.typeIds = typeIds;
  }

  /**
   * Method to retrieve Source Id.
   * 
   */
  public final Long getSourceId() {
    return sourceId;
  }

  /**
   * Method to retrieve Destination Id.
   * 
   */
  public final Long getDestinationId() {
    return destinationId;
  }

  /**
   * Method to retrieve Set of Operator Ids.
   * 
   */
  public final Set<Long> getOperatorIds() {
    return operatorIds;
  }

  /**
   * Method to retrieve Set of Type Ids.
   * 
   */
  public final Set<Long> getTypeIds() {
    return typeIds;
  }
}
