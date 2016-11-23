package com.chooseacab.rest.ridedetails;

import com.chooseacab.model.RideDetails;
import com.chooseacab.search.RideDetailsSearch;
import com.chooseacab.service.RideDetailsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
@Transactional
public class RideDetailsRepresentationServiceImpl implements RideDetailsRepresentationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    protected RideDetailsService rideDetailsService;

    @Override
    public List<RideDetailsRepresentation> searchRideDetails(RideDetailsSearch rideDetailsSearch) {
        LOGGER.debug("Entering RideDetailsRepresentationServiceImpl.searchRideDetails");

        List<RideDetails> rideDetails = rideDetailsService.searchRideDetails(rideDetailsSearch);

        LOGGER.debug("Exiting RideDetailsRepresentationServiceImpl.searchRideDetails");

        return RideDetailsRepresentation.toRepresentations(rideDetails);
    }
}
