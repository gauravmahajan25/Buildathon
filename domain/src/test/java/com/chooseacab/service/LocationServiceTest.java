package com.chooseacab.service;

import com.chooseacab.model.Location;
import com.chooseacab.repository.LocationJpaRepository;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test Class for Location Service.
 */
@Test
public class LocationServiceTest {

  private LocationJpaRepository locationJpaRepository;

  @BeforeTest
  public void setup() {
    locationJpaRepository = mock(LocationJpaRepository.class);
  }

  /**
   * Test case for get all locations service method.
   */
  @Test
  public void testGetAllLocations() {
    final Location location = new Location();
    location.setName("LOC1");
    location.setZipCode(143001);

    final List<Location> expected = new ArrayList<>();
    expected.add(location);

    when(locationJpaRepository.getAllLocations()).thenReturn(expected);

    final Collection<Location> actual = locationJpaRepository.getAllLocations();

    Assert.assertEquals(actual.size(), expected.size());
  }
}
