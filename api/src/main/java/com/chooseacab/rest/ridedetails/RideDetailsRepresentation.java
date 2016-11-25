package com.chooseacab.rest.ridedetails;

import com.chooseacab.model.RideDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * A resource representation class for Ride Details.
 */
public class RideDetailsRepresentation {

  private Long id;

  private String operatorName;

  private String typeName;

  private Double fare;

  private Integer discount;

  public RideDetailsRepresentation(){
	  //default constructor.
  }

  /**
   * Instantiates the RideDetails Representation based on RideDetails passed.
   * 
   */
  public RideDetailsRepresentation(final RideDetails rideDetails){
    setId(rideDetails.getId());
    setOperatorName(rideDetails.getFareDetails().getOperator().getName());
    setTypeName(rideDetails.getFareDetails().getType().getName());
    setFare(rideDetails.getFareDetails().getFare());
    setDiscount(rideDetails.getFareDetails().getDiscount());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOperatorName() {
    return operatorName;
  }

  public void setOperatorName(String operatorName) {
    this.operatorName = operatorName;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public Double getFare() {
    return fare;
  }

  public void setFare(Double fare) {
    this.fare = fare;
  }

  public Integer getDiscount() {
    return discount;
  }

  public void setDiscount(Integer discount) {
    this.discount = discount;
  }

  /**
   * Get the Ride Details Representation based on RideDetails passed.
   * @param List - rideDetails
   * @return List - List of Ride Details representation.
   * 
   */
  public static List<RideDetailsRepresentation> toRepresentations(final List<RideDetails> rideDetails){
    final List<RideDetailsRepresentation> representations = new ArrayList<>();
    for(final RideDetails rideDetail:rideDetails){
      final RideDetailsRepresentation representation = new RideDetailsRepresentation(rideDetail);
      representations.add(representation);
    }
    return representations;
  }
}
