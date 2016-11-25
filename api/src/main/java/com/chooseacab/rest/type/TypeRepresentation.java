package com.chooseacab.rest.type;

import com.chooseacab.model.Type;

import java.util.ArrayList;
import java.util.List;

/*
 * A resource representation class for Type entity.
 */
public class TypeRepresentation {

  public Long id;

  public String name;

  private Integer zipCode;

  /**
   * Default Constructor
   */
  public TypeRepresentation() {
    //default constructor.
  }

  /**
   * Instantiate the Type Representation by injecting Type parameters.
   *
   * @param type - Type for which the representation needs to be generated.
   */

  public TypeRepresentation(Type type) {
    setId(type.getId());
    setName(type.getName());
  }

  /**
   * Generate Type Representation list from Type List.
   *
   * @param types - Type List
   * @return - Type Representation list.
   */
  public static List<TypeRepresentation> toRepresentations(List<Type> types) {
    final List<TypeRepresentation> representations = new ArrayList<>();

    for (Type type : types) {
      final TypeRepresentation representation = new TypeRepresentation(type);
      representations.add(representation);
    }
    return representations;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
