package com.chooseacab.rest.type;

import com.chooseacab.model.Type;

import java.util.ArrayList;
import java.util.List;

/*
 * A resource representation class for Type entity.
 */
public class TypeRepresentation {

  private Long id;

  private String name;

  /**
   * Default Constructor.
   */
  public TypeRepresentation() {
    //default constructor.
  }

  /**
   * Instantiate the Type Representation by injecting Type parameters.
   *
   * @param type - Type for which the representation needs to be generated.
   */

  public TypeRepresentation(final Type type) {
    setId(type.getId());
    setName(type.getName());
  }

  /**
   * Generate Type Representation list from Type List.
   *
   * @param types - Type List
   * @return - Type Representation list.
   */
  public static List<TypeRepresentation> toRepresentations(final List<Type> types) {
    final List<TypeRepresentation> representations = new ArrayList<>();

    for (Type type : types) {
      final TypeRepresentation representation = new TypeRepresentation(type);
      representations.add(representation);
    }
    return representations;
  }

  /**
   * Get id.
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * Set id.
   * @param id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get name.
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Set name.
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }
}
