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

  /**
   * Default constructor.
   */
  public LocationRepresentation(){
  }
  
  /**
   * Instates Location Reprentation for location passed.
   * @param location for which the representation needs to be generated.
   * 
   */
  public LocationRepresentation(Location location){
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
   * Get id
   * @param id
   */
  public final void setId(Long id) {
    this.id = id;
  }

  /**
   * Get name
   * @return name
   */
  public final String getName() {
    return name;
  }

  /**
   * Set name
   * @param name
   */
  public final void setName(String name) {
    this.name = name;
  }

  /**
   * Get zip code
   * @return
   */
  public final Integer getZipCode() {
    return zipCode;
  }

  /**
   * Set zip code
   * @param zipCode
   */
  public final void setZipCode(Integer zipCode) {
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
