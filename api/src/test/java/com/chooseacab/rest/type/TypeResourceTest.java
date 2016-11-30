package com.chooseacab.rest.type;

import com.chooseacab.rest.AbstractTestNGJerseyDBUnitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A test class for Type Resource.
 */
public class TypeResourceTest extends AbstractTestNGJerseyDBUnitTest {


  @Override
  public String getDataSetFileName() {
    return "dataset/TypeResourceTest_DBUnit.xml";
  }

  @Override
  protected Class[] resourcesToRegister() {
    return new Class[]{TypeResource.class};
  }

  /**
   * Test for End Point Name.
   */
  @Test
  public void testEndpointName() {
    final String endpointName = TypeResource.RESOURCE_IDENTIFIER;
    Assert.assertEquals(endpointName, "/type");
  }

  /**
   * Test for End getting all types.
   */
  @Test
  public void testGetAllTypes() throws Exception {
    final Response
        response =
        target(TypeResource.RESOURCE_IDENTIFIER).request().accept(MediaType.APPLICATION_JSON)
            .get();

    Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);
  }
}
