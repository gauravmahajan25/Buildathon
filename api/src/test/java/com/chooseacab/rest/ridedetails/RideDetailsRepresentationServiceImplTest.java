package com.chooseacab.rest.ridedetails;

import com.chooseacab.model.FareDetails;
import com.chooseacab.model.Location;
import com.chooseacab.model.Operator;
import com.chooseacab.model.RideDetails;
import com.chooseacab.model.Type;
import com.chooseacab.search.RideDetailsSearch;
import com.chooseacab.service.RideDetailsService;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.when;
/**
 * Test class for Ride Details Representation Service.
 * 
 */
public class RideDetailsRepresentationServiceImplTest {

  @Mock
  private RideDetailsService rideDetailsService;

  private RideDetailsRepresentationService rideDetailsRepresentationService;
  /**
   * before test initialization
   */
  @BeforeClass
  public void beforeTest() {
    MockitoAnnotations.initMocks(this);
    rideDetailsRepresentationService =
        new RideDetailsRepresentationServiceImpl();
    ReflectionTestUtils
        .setField(rideDetailsRepresentationService, "rideDetailsService", rideDetailsService);
  }

  /**
   * test for search details.
   */
  @Test
  public void searchTest() {

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
    fareDetails.setFare(12.33);
    fareDetails.setDiscount(2);

    final RideDetails rideDetails = new RideDetails();
    rideDetails.setSourceLocation(sourceLocation);
    rideDetails.setDestinationLocation(destinationLocation);
    rideDetails.setFareDetails(fareDetails);

    List<RideDetails> rideDetailses= new ArrayList<>();
    rideDetailses.add(rideDetails);

    final RideDetailsSearch rideDetailsSearch =
        new RideDetailsSearch(1001L,
                              1001L,
                              new HashSet<Long>(Arrays.asList(1001L)),
                              new HashSet<Long>(Arrays.asList(1001L)));

    Collection<RideDetailsRepresentation> actual = RideDetailsRepresentation.toRepresentations(rideDetailses);

    when(rideDetailsService.searchRideDetails(rideDetailsSearch)).thenReturn(rideDetailses);

    Collection<RideDetailsRepresentation> expected =
        rideDetailsRepresentationService.searchRideDetails(rideDetailsSearch);

    Assert.assertEquals(actual.size(), expected.size());
 }
}
