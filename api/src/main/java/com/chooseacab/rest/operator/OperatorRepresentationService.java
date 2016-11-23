package com.chooseacab.rest.operator;

import java.util.List;

/**
 * This class will take care of handling delegating request to service class.
 */
public interface OperatorRepresentationService {

    List<OperatorRepresentation> getOperators();
}
