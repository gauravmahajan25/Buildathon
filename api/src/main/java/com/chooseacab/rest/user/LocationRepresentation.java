package com.chooseacab.rest.user;

import com.chooseacab.model.Location;

import java.util.ArrayList;
import java.util.List;

/*
 * A resource representation class for Location entity.
 */
public class LocationRepresentation {

  public Long id;

  public String name;

  private Integer zipCode;

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

  public LocationRepresentation(){

  }

  public LocationRepresentation(Location location){
    setId(location.getId());
    setName(location.getName());
    setZipCode(location.getZipCode());
  }

  public static List<LocationRepresentation> toRepresentations(List<Location> locations){
    List<LocationRepresentation> representations = new ArrayList<>();
    for(Location location:locations){
      LocationRepresentation representation = new LocationRepresentation(location);
      representations.add(representation);
    }
    return representations;
  }
}
