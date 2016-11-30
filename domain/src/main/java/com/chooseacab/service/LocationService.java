package com.chooseacab.service;

import com.chooseacab.model.Location;

import java.util.List;

/**
 * The service class for Location.
 */
public interface LocationService {

	/**
     * Get All Locations.
     * @return list of locations
     */
    List<Location> getAllLocations();
}
