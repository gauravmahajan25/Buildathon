package com.chooseacab.repository;

import com.chooseacab.model.RideDetails;
import com.chooseacab.search.RideDetailsSearch;

import java.util.List;

/**
 * A repository for FareDetails entity.
 */
public interface RideDetailsJpaRepository extends JpaRepository<RideDetails> {

  /**
   * Search Ride details
   * @return list of rideDetails
   */
  List<RideDetails> searchRideDetails(RideDetailsSearch rideDetailsSearch);
}
