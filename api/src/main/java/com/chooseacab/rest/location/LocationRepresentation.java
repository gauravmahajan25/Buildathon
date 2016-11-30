package com.chooseacab.rest.location;

import com.chooseacab.model.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * A resource representation class for Location entity.
 */
public class LocationRepresentation {

/**
 * Property for Location Id.
 */
  private Long id;

  /**
   * Property for Location Name.
   */
  private String name;

  /**
   * Property for Location Zip code.
   */
  private Integer zipCode;

  /**
   * Default constructor.
   */
  public LocationRepresentation(){
  }
  
  /**
   * Instantiates Location Reprentation for location passed.
   * @param location for which the representation needs to be generated.
   * 
   */
  public LocationRepresentation(final Location location){
    setId(location.getId());
    setName(location.getName());
    setZipCode(location.getZipCode());
  }

  /**
   * Set id.
   * @return id
   */
  public final Long getId() {
    return id;
  }

  /**
   * Get id.
   * @param id
   */
  public final void setId(final Long id) {
    this.id = id;
  }

  /**
   * Get name.
   * @return name
   */
  public final String getName() {
    return name;
  }

  /**
   * Set name.
   * @param name
   */
  public final void setName(final String name) {
    this.name = name;
  }

  /**
   * Get zip code.
   * @return Integer - zipcode.
   */
  public final Integer getZipCode() {
    return zipCode;
  }

  /**
   * Set zip code.
   * @param zipCode
   */
  public final void setZipCode(final Integer zipCode) {
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
