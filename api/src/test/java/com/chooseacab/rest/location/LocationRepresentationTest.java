package com.chooseacab.rest.location;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * A test class for Location Representation. This class unit tests the name, zip and id for a
 * location.
 */
public class LocationRepresentationTest {

  /**
   * Method to test location name.
   */
  @Test
  public void testLocationName() {
    final LocationRepresentation representation = new LocationRepresentation();
    representation.setName("Hyderabad");

    final String locationName = representation.getName();
    Assert.assertEquals("Hyderabad", locationName, "Location Name equals Test passed");
  }

  /**
   * Method to test locationId.
   */
  @Test
  public void testLocationId() {
    final LocationRepresentation representation = new LocationRepresentation();
    representation.setId(10001L);

    final long locationId = representation.getId();
    Assert.assertEquals(10001L, locationId, "Location ID equals Test passed");
  }

  /**
   * Method to test location zip code.
   */
  @Test
  public void testZipCode() {
    final LocationRepresentation representation = new LocationRepresentation();
    representation.setName("143001");

    final String zip = representation.getName();
    Assert.assertEquals("143001", zip, "Location ZIP equals Test passed");
  }
}