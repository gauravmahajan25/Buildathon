package com.chooseacab.rest.location;

import java.util.List;

/**
 * This interface will take care of handling validations & delegating request to service class.
 */
public interface LocationRepresentationService {
	/**
	 * Api to get all locations
	 * @return List of Locatin Representation.
	 */
    List<LocationRepresentation> getAllLocations();
}
