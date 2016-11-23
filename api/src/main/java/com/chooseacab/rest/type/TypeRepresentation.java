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

  public TypeRepresentation(){

  }

  public TypeRepresentation(Type type){
    setId(type.getId());
    setName(type.getName());
  }

  public static List<TypeRepresentation> toRepresentations(List<Type> types){
    List<TypeRepresentation> representations = new ArrayList<>();

    for(Type type:types){
      TypeRepresentation representation = new TypeRepresentation(type);
      representations.add(representation);
    }
    return representations;
  }
}
