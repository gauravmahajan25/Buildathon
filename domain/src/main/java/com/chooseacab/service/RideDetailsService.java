package com.chooseacab.service;

import com.chooseacab.model.RideDetails;
import com.chooseacab.search.RideDetailsSearch;

import java.util.List;

/**
 * The service class for Ride Details.
 */
public interface RideDetailsService {

    /**
     * Search Ride details.
     * @return list of rideDetails
     */
    List<RideDetails> searchRideDetails(RideDetailsSearch rideDetailsSearch);
}
