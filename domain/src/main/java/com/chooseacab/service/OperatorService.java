package com.chooseacab.service;

import com.chooseacab.model.Operator;

import java.util.List;

/**
 * The service class for Operator.
 */
public interface OperatorService {

	/**
     * Get Operators
     * @return list of operators
     */
    List<Operator> getOperators();
}
