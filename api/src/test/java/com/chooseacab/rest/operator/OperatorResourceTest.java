package com.chooseacab.rest.operator;

import com.chooseacab.rest.AbstractTestNGJerseyDBUnitTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Test class for Operator Resource.
 */
public class OperatorResourceTest extends AbstractTestNGJerseyDBUnitTest {

  /**
   *
   * @return string dateset file.
   */
  @Override
  public String getDataSetFileName() {
    return "dataset/OperatorsResourceTest_DBUnit.xml";
  }

  /**
   *
   * @return object
   */
  @Override
  protected Class[] resourcesToRegister() {
    return new Class[]{OperatorResource.class};
  }

  /**
   * Test endpoint name
   */
  @Test
  public void testEndpointName() {
    final String endpointName = OperatorResource.RESOURCE_IDENTIFIER;
    Assert.assertEquals(endpointName, "/operator");
  }

  /**
   * Test get operators.
   * @throws Exception
   */
  @Test
  public void testGetOperators() throws Exception {
    final Response response = target(OperatorResource.RESOURCE_IDENTIFIER).request()
        .accept(MediaType.APPLICATION_JSON).get();

    Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);
  }
}
