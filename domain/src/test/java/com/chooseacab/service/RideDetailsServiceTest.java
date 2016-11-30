package com.chooseacab.service;

import com.chooseacab.model.*;
import com.chooseacab.repository.RideDetailsJpaRepository;
import com.chooseacab.search.RideDetailsSearch;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for RideDetailsService.
 */
@Test
public class RideDetailsServiceTest {

  private static RideDetailsJpaRepository rideDetailsJpaRepository;

  @BeforeTest
  public final void setup() {
    rideDetailsJpaRepository = mock(RideDetailsJpaRepository.class);
  }

  /**
   * Test for search.
   */
  @Test
  public final void testSearch() {
    final Location sourceLocation = new Location();
    sourceLocation.setName("SRC_LOC1");

    final Location destinationLocation = new Location();
    destinationLocation.setName("DEST_LOC1");

    final Operator operator = new Operator();
    operator.setName("OP1");

    final Type type = new Type();
    type.setName("TYP1");

    final FareDetails fareDetails = new FareDetails();
    fareDetails.setOperator(operator);
    fareDetails.setType(type);
    fareDetails.setFare(12d);
    fareDetails.setDiscount(2);

    final RideDetails rideDetails = new RideDetails();
    rideDetails.setSourceLocation(sourceLocation);
    rideDetails.setDestinationLocation(destinationLocation);
    rideDetails.setFareDetails(fareDetails);

    List<RideDetails> expected= new ArrayList<>();
    expected.add(rideDetails);

    final RideDetailsSearch rideDetailsSearch =
        new RideDetailsSearch(1001L,
                              1001L,
                              new HashSet<Long>(Arrays.asList(1001L)),
                              new HashSet<Long>(Arrays.asList(1001L)));

    when(rideDetailsJpaRepository.searchRideDetails(rideDetailsSearch)).thenReturn(expected);

    Collection<RideDetails> actual =
        rideDetailsJpaRepository.searchRideDetails(rideDetailsSearch);

    Assert.assertEquals(actual.size(), expected.size());
  }
}
