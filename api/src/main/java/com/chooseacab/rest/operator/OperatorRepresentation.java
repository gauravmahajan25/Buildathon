package com.chooseacab.rest.operator;

import com.chooseacab.model.Operator;

import java.util.ArrayList;
import java.util.List;

/*
 * A resource representation class for Operator entity.
 */
public class OperatorRepresentation {

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

  public OperatorRepresentation(){

  }

  public OperatorRepresentation(Operator operator){
    setId(operator.getId());
    setName(operator.getName());
  }

  public static List<OperatorRepresentation> toRepresentations(List<Operator> operators){
    List<OperatorRepresentation> representations = new ArrayList<>();

    for(Operator operator:operators){
      OperatorRepresentation representation = new OperatorRepresentation(operator);
      representations.add(representation);
    }
    return representations;
  }
}
