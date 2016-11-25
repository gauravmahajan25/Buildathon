package com.chooseacab.rest.operator;

import java.util.List;

/**
 * This interface will take care of handling delegating request to service
 * class.
 */
public interface OperatorRepresentationService {

	/**
	 * Get All available Operator
	 * 
	 * @return list of operators
	 */
	List<OperatorRepresentation> getOperators();
}
