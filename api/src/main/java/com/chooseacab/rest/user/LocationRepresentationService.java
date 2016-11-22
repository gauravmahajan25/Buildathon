package com.chooseacab.rest.user;

import java.util.List;

/**
 * This class will take care of handling validations & delegating request to service class.
 */
public interface LocationRepresentationService {

    List<LocationRepresentation> getAllLocations();
}
