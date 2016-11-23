package com.chooseacab.rest.ridedetails;

import com.chooseacab.search.RideDetailsSearch;

import java.util.List;

/**
 * This class will take care of delegating request to service class.
 */
public interface RideDetailsRepresentationService {

    List<RideDetailsRepresentation> searchRideDetails(RideDetailsSearch rideDetailsSearch);
}
