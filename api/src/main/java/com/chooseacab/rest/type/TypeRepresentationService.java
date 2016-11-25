package com.chooseacab.rest.type;

import java.util.List;

/**
 * This class will take care of handling delegating request to service class.
 */
public interface TypeRepresentationService {

  /**
   * Return all Types.
   *
   * @return List of Types.
   */
  List<TypeRepresentation> getTypes();
}
