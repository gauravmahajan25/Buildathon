package com.chooseacab.rest.ridedetails;

import com.chooseacab.rest.AbstractTestNGJerseyDBUnitTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InputStream;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Test class for Ride Details Resource.
 * 
 *
 */
public class RideDetailsResourceTest extends AbstractTestNGJerseyDBUnitTest {

    @Override
    public String getDataSetFileName() {
        return "dataset/RideDetailsResourceTest_DBUnit.xml"; }

    @Override
    protected Class[] resourcesToRegister() {
        return new Class[]{RideDetailsResource.class};
    }

    /**
	 * Test case to test end point name.
	 * 
	 */
    @Test
    public void testEndpointName() {
        final String endpointName = RideDetailsResource.RESOURCE_IDENTIFIER;
        Assert.assertEquals(endpointName, "/ride-details");
    }

    /**
	 * Test case to test search api.
	 * 
	 */
    @Test
    public void testSearch() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), "1001");
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), "OLA");
        Assert.assertEquals(rootNode.findValue("typeName").asText(), "SUV");
        Assert.assertEquals(rootNode.findValue("fair").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
	 * Test case to test search by source id.
	 * 
	 */
    @Test
    public void testSearchBySourceId() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("sourceId", "1001")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), "1001");
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), "OLA");
        Assert.assertEquals(rootNode.findValue("typeName").asText(), "SUV");
        Assert.assertEquals(rootNode.findValue("fair").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
   	 * Negative Test case to test search by source id not found.
   	 * 
   	 */
    @Test
    public void testSearchBySourceIdNotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("sourceId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    /**
   	 * Test case to test search by destination id.
   	 * 
   	 */
    @Test
    public void testSearchByDestinationId() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("destinationId", "1002")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), "1001");
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), "OLA");
        Assert.assertEquals(rootNode.findValue("typeName").asText(), "SUV");
        Assert.assertEquals(rootNode.findValue("fair").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
   	 * Test case to test search by destination id not found.
   	 * 
   	 */
    @Test
    public void testSearchByDestinationIdNotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("destinationId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    /**
   	 * Test case to test search by operator id.
   	 * 
   	 */
    @Test
    public void testSearchByOperatorId() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("operatorId", "1001")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), "1001");
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), "OLA");
        Assert.assertEquals(rootNode.findValue("typeName").asText(), "SUV");
        Assert.assertEquals(rootNode.findValue("fair").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
   	 * Negative Test case to test search by operator id not found.
   	 * 
   	 */
    @Test
    public void testSearchByOperatorIdNotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("operatorId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    /**
   	 * Test case to test search by type id.
   	 * 
   	 */
    @Test
    public void testSearchByTypeId() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("typeId", "1001")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), "1001");
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), "OLA");
        Assert.assertEquals(rootNode.findValue("typeName").asText(), "SUV");
        Assert.assertEquals(rootNode.findValue("fair").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
  	 * Test case to test search by type id not found.
  	 * 
  	 */
    @Test
    public void testSearchByTypeIdNotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("typeId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    /**
  	 * Test case to test search by dependent parameter ids.
  	 * 
  	 */
    @Test
    public void testSearchByDependentIds() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("sourceId", "1001")
            .queryParam("destinationId", "1002")
            .queryParam("operatorId", "1001")
            .queryParam("typeId", "1001")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), "1001");
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), "OLA");
        Assert.assertEquals(rootNode.findValue("typeName").asText(), "SUV");
        Assert.assertEquals(rootNode.findValue("fair").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
  	 * Test case to test search by dependent id not found.
  	 * 
  	 */
    @Test
    public void testSearchByDependentIdsNotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("sourceId", "1001")
            .queryParam("destinationId", "1002")
            .queryParam("operatorId", "1001")
            .queryParam("typeId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }
}
