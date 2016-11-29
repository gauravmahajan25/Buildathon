package com.chooseacab.service;

import com.chooseacab.model.Type;

import java.util.List;

/**
 * The service class for Type.
 */
public interface TypeService {

	/**
     * Get Types
     * @return list of types
     */
    List<Type> getTypes();
}
