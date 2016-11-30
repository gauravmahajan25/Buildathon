package com.chooseacab.rest.location;

import com.chooseacab.model.Location;
import com.chooseacab.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.List;

/**
 * Class to implement Location Representation Service.
 *
 */
@Service
@Transactional
public class LocationRepresentationServiceImpl implements LocationRepresentationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private transient LocationService locationService;

    /**
     * Get All Locations.
     * @return List - list of LocationRepresentation
     */
    @Override
    public final List<LocationRepresentation> getAllLocations() {
        LOGGER.debug("Entering LocationRepresentationServiceImpl.getAllLocations");

        final List<Location> locations = locationService.getAllLocations();

        LOGGER.debug("Exiting LocationRepresentationServiceImpl.getAllLocations");

        return LocationRepresentation.toRepresentations(locations);
    }


}
