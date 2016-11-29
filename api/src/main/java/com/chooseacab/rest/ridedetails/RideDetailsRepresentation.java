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
  
  /**
   * default constructor
   */
  public RideDetailsRepresentation(){
	  //default constructor.
  }

  /**
   * Instantiates the RideDetails Representation based on RideDetails passed.
   * @param rideDetails rider details object
   */
  public RideDetailsRepresentation(final RideDetails rideDetails){
    setId(rideDetails.getId());
    setOperatorName(rideDetails.getFareDetails().getOperator().getName());
    setTypeName(rideDetails.getFareDetails().getType().getName());
    setFare(rideDetails.getFareDetails().getFare());
    setDiscount(rideDetails.getFareDetails().getDiscount());
  }
  /**
   * get the rider details id
   * @return rider details id
   */
  public Long getId() {
    return id;
  }
  /**
   * set the rider details id
   * @param id rider details id
   */
  public void setId(Long id) {
    this.id = id;
  }
  /**
   * get the operator name
   * @return operator name
   */
  public String getOperatorName() {
    return operatorName;
  }
  /**
   * set the operator name
   * @param operatorName 
   */
  public void setOperatorName(String operatorName) {
    this.operatorName = operatorName;
  }
  /**
   * get type name
   * @return type name
   */
  public String getTypeName() {
    return typeName;
  }
  /**
   * set the type name
   * @param typeName
   */
  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }
  /**
   * get the fare
   * @return fare
   */
  public Double getFare() {
    return fare;
  }
  /**
   * set the fare
   * @param fare
   */
  public void setFare(Double fare) {
    this.fare = fare;
  }
  /**
   * get the discount
   * @return discount
   */
  public Integer getDiscount() {
    return discount;
  }
  /**
   * set the doscount
   * @param discount
   */
  public void setDiscount(Integer discount) {
    this.discount = discount;
  }

  /**
   * Get the Ride Details Representation based on RideDetails passed.
   * @param rideDetails - rideDetails
   * @return List of Ride Details representation.
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
