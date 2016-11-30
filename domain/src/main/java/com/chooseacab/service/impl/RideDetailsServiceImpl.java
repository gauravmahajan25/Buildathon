package com.chooseacab.service.impl;

import com.chooseacab.model.RideDetails;
import com.chooseacab.repository.RideDetailsJpaRepository;
import com.chooseacab.search.RideDetailsSearch;
import com.chooseacab.service.RideDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * RideDetails Service Implementation class.
 * Provides api to search Ride Details.
 */
@Service
@Transactional
public class RideDetailsServiceImpl implements RideDetailsService {

	/**
	 * Property for RideDetailsJpaRepository.
	 */
     private RideDetailsJpaRepository rideDetailsJpaRepository;

     /**
      * Constructor to initialize RideDetailsJpaRepository.
      * @param RideDetailsJpaRepository
      */
     @Autowired
    public RideDetailsServiceImpl(final RideDetailsJpaRepository rideDetailsJpaRepository) {
        this.rideDetailsJpaRepository = rideDetailsJpaRepository;
    }

     /**
      * Search Ride Details.
      * @param RideDetailsSearch
      * @return List - list of Ride Details.
      */
    @Override
    public List<RideDetails> searchRideDetails(RideDetailsSearch rideDetailsSearch) {
        return rideDetailsJpaRepository.searchRideDetails(rideDetailsSearch);
    }
}
