package com.chooseacab.service.impl;

import com.chooseacab.model.Location;
import com.chooseacab.repository.LocationJpaRepository;
import com.chooseacab.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Location Service Implementation class.
 * Provides api to get all Locations.
 */
@Service
@Transactional
public class LocationServiceImpl implements LocationService {

	/**
	 * LocationJpaRepository property for Location service.
	 */
    private LocationJpaRepository locationJpaRepository;

    /**
     * Constructor to initialize LocationJpaRepository.
     * @param LocationJpaRepository
     */
    @Autowired
    public LocationServiceImpl(final LocationJpaRepository locationJpaRepository) {
        this.locationJpaRepository = locationJpaRepository;
    }

    /**
     * Get All Locations.
     * @return List - list of locaitons.
     */
    @Override
    public List<Location> getAllLocations(){
        return locationJpaRepository.getAllLocations();
    }
}
