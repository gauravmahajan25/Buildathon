package com.chooseacab.rest.ridedetails;

import com.chooseacab.rest.AbstractTestNGJerseyDBUnitTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InputStream;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class OperatorResourceTest extends AbstractTestNGJerseyDBUnitTest {

	@Override
	public String getDataSetFileName() {
		return "dataset/operatorResourceTest_DBUnit.xml";
	}

	@Override
	protected Class[] resourcesToRegister() {
		return new Class[] { RideDetailsResource.class };
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
