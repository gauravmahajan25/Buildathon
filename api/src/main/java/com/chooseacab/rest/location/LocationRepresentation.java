package com.chooseacab.rest.location;

import com.chooseacab.model.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * A resource representation class for Location entity.
 */
public class LocationRepresentation {

  private Long id;

  private String name;

  private Integer zipCode;

  public LocationRepresentation(){
	  //default constructor
  }
  
  /**
   * Instates Location Reprentation for location passed.
   * @param Location for which the representation needs to be generated.
   * 
   */
  public LocationRepresentation(Location location){
    setId(location.getId());
    setName(location.getName());
    setZipCode(location.getZipCode());
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getZipCode() {
    return zipCode;
  }

  public void setZipCode(Integer zipCode) {
    this.zipCode = zipCode;
  }

  /**
   * Returns the Location Representations for the list of locations.
   * @param locations - List of locations
   * @return List of Location Representations.
   */
  public static List<LocationRepresentation> toRepresentations(final List<Location> locations){
    final List<LocationRepresentation> representations = new ArrayList<>();
    for(final Location location:locations){
      final LocationRepresentation representation = new LocationRepresentation(location);
      representations.add(representation);
    }
    return representations;
  }
}
