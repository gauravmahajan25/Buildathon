package com.chooseacab.rest.type;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * A test class for Type Representation. This class unit tests the name and id for a type.
 */
public class TypeRepresentationTest {

  /**
   * Test case to test equals typeName.
   */
  @Test
  public void testEqualsTypeName() {
    final TypeRepresentation representation = new TypeRepresentation();
    representation.setName("SEDAN");

    final String typeName = representation.getName();
    Assert.assertEquals("SEDAN", typeName, "Type Name Test passed");
  }

  /**
   * Test case to test equals typeId.
   */
  @Test
  public void testEqualsTypeId() {
    final TypeRepresentation representation = new TypeRepresentation();
    representation.setId(10001L);
    representation.setName("MUV");

    final long typeId = representation.getId();
    Assert.assertEquals(10001L, typeId, "Type ID Test passed");
  }

  /**
   * Test case to test not equals type name.
   */
  @Test
  public void testNotEqualsTypeName() {
    final TypeRepresentation representation = new TypeRepresentation();
    representation.setName("SEDAN");

    final String typeName = representation.getName();
    Assert.assertNotEquals("MUV", typeName, "Not Equals Type Name Test passed");
  }

  /**
   * Test case to test not equals typeId.
   */
  @Test
  public void testNotEqualsTypeId() {
    final TypeRepresentation representation = new TypeRepresentation();
    representation.setId(10001L);
    representation.setName("MUV");

    final long typeId = representation.getId();
    Assert.assertNotEquals(10003L, typeId, "Not Equals Type ID Test passed");
  }
}
