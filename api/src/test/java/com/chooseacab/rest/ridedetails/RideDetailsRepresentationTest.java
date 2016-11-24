package com.chooseacab.rest.ridedetails;

import org.junit.Assert;
import org.junit.Test;

public class RideDetailsRepresentationTest {

  @Test
  public void testSetterAndGetter_OperatorName(){
    RideDetailsRepresentation representation = new RideDetailsRepresentation();
    representation.setOperatorName("OLA");

    String operatorName = representation.getOperatorName();

    Assert.assertEquals("OLA", operatorName);
  }

  @Test
  public void testSetterAndGetter_TypeName(){
    RideDetailsRepresentation representation = new RideDetailsRepresentation();
    representation.setTypeName("SUV");

    String typeName = representation.getTypeName();

    Assert.assertEquals("SUV", typeName);
  }

  @Test
  public void testSetterAndGetter_Fare(){
    double fare = 2;
    RideDetailsRepresentation representation = new RideDetailsRepresentation();
    representation.setFare(fare);

    double expectedFare = representation.getFare();

    Assert.assertEquals(expectedFare, fare, 1);
  }

  @Test
  public void testSetterAndGetter_Discount(){
    RideDetailsRepresentation representation = new RideDetailsRepresentation();
    representation.setDiscount(2);

    int discount = representation.getDiscount();

    Assert.assertEquals(2, discount);
  }
}
