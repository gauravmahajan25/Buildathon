package com.chooseacab.rest.location;

import com.chooseacab.model.Location;
import com.chooseacab.service.LocationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
@Transactional
public class LocationRepresentationServiceImpl implements LocationRepresentationService {

    private static final Logger
            LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    protected LocationService locationService;

    @Override
    public List<LocationRepresentation> getAllLocations() {
        LOGGER.debug("Entering LocationRepresentationServiceImpl.getAllLocations");

        List<Location> locations = locationService.getAllLocations();

        LOGGER.debug("Exiting LocationRepresentationServiceImpl.getAllLocations");

        return LocationRepresentation.toRepresentations(locations);
    }
}
