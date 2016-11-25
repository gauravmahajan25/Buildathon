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

  @Override
  public String getDataSetFileName() {
    return "dataset/operatorResourceTest_DBUnit.xml";
  }

  @Override
  protected Class[] resourcesToRegister() {
    return new Class[]{OperatorResource.class};
  }

  @Test
  public void testEndpointName() {
    final String endpointName = OperatorResource.RESOURCE_IDENTIFIER;
    Assert.assertEquals(endpointName, "/operator");
  }

  @Test
  public void testGetOperators() throws Exception {
    final Response response = target(OperatorResource.RESOURCE_IDENTIFIER).request()
        .accept(MediaType.APPLICATION_JSON).get();

    Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);
  }
}
