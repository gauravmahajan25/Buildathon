package com.chooseacab.rest.operator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for Operator Representation.
 */
public class OperatorRepresentationTest {

  /**
   * Test case for Operator Name.
   */
  @Test
  public void testOperatorName() {
    final OperatorRepresentation representation = new OperatorRepresentation();
    representation.setName("OLA");

    final String operatorName = representation.getName();

    Assert.assertEquals("OLA", operatorName);
  }

  /**
   * Test case for Operator Id
   */
  @Test
  public void testOperatorId() {
    final OperatorRepresentation representation = new OperatorRepresentation();
    representation.setId(101l);

    final long operatorId = representation.getId();

    Assert.assertEquals(101L, operatorId);
  }
}
