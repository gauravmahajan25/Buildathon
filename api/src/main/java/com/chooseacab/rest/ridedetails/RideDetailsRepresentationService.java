package com.chooseacab.rest.ridedetails;

import com.chooseacab.search.RideDetailsSearch;

import java.util.List;

/**
 * This class will take care of delegating request to service class.
 */
public interface RideDetailsRepresentationService {

	/**
	 * Retrieves the List of Ride Details based on Searach criteria.
	 * @param rideDetailsSearch
	 * @return List- List of Ride Details.
	 */
    List<RideDetailsRepresentation> searchRideDetails(RideDetailsSearch rideDetailsSearch);
}
