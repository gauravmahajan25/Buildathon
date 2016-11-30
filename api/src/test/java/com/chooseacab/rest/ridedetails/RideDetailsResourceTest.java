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
 */
public class RideDetailsResourceTest extends AbstractTestNGJerseyDBUnitTest {

    private final String ID_1001 = "1001";

    private final String OLA = "OLA";

    private final String SUV = "SUV";
    /**
     * Get Data set file.
     * @return string d=Data set file.
     */
    @Override
    public final String getDataSetFileName() {
        return "dataset/RideDetailsResourceTest_DBUnit.xml"; }

    /**
     *
     * @return obj
     */
    @Override
    protected final Class[] resourcesToRegister() {
        return new Class[]{RideDetailsResource.class};
    }

    /**
	 * Test case to test end point name.
	 * 
	 */
    @Test
    public final void testEndpointName() {
        final String endpointName = RideDetailsResource.RESOURCE_IDENTIFIER;
        Assert.assertEquals(endpointName, "/ride-details");
    }

    /**
     * Test case to test search api.
     * @throws Exception unknown exception
     */
    @Test
    public final void testSearch() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), ID_1001);
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), OLA);
        Assert.assertEquals(rootNode.findValue("typeName").asText(), SUV);
        Assert.assertEquals(rootNode.findValue("fare").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
	 * Test case to test search by source id.
	 * @throws Exception unknown exception
	 */
    @Test
    public final void testSearchBySourceId() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("sourceId", ID_1001)
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), ID_1001);
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), OLA);
        Assert.assertEquals(rootNode.findValue("typeName").asText(), SUV);
        Assert.assertEquals(rootNode.findValue("fare").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
   	 * Negative Test case to test search by source id not found.
   	 * @throws Exception unknown exception
   	 */
    @Test
    public final void testSearchBySourceIdNotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("sourceId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    /**
   	 * Test case to test search by destination id.
   	 * @throws Exception unknown exception
   	 */
    @Test
    public final void testSearchByDestinationId() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("destinationId", "1002")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), ID_1001);
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), OLA);
        Assert.assertEquals(rootNode.findValue("typeName").asText(), SUV);
        Assert.assertEquals(rootNode.findValue("fare").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
   	 * Test case to test search by destination id not found.
   	 * @throws Exception unknown exception
   	 */
    @Test
    public final void testSearchByDestinationIdNotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("destinationId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    /**
   	 * Test case to test search by operator id.
   	 * @throws Exception unknown exception
   	 */
    @Test
    public final void testSearchByOperatorId() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("operatorId", ID_1001)
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), ID_1001);
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), OLA);
        Assert.assertEquals(rootNode.findValue("typeName").asText(), SUV);
        Assert.assertEquals(rootNode.findValue("fare").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
   	 * Negative Test case to test search by operator id not found.
   	 * @throws Exception unknown exception
   	 */
    @Test
    public final void testSearchByOperatorIdNotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("operatorId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    /**
   	 * Test case to test search by type id.
   	 * @throws Exception unknown exception
   	 */
    @Test
    public final void testSearchByTypeId() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("typeId", ID_1001)
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), ID_1001);
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), OLA);
        Assert.assertEquals(rootNode.findValue("typeName").asText(), SUV);
        Assert.assertEquals(rootNode.findValue("fare").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
  	 * Test case to test search by type id not found.
  	 * @throws Exception unknown exception
  	 */
    @Test
    public final void testSearchByTypeIdNotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("typeId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    /**
  	 * Test case to test search by dependent parameter ids.
  	 * @throws Exception unknown exception
  	 */
    @Test
    public final void testSearchByDependentIds() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("sourceId", ID_1001)
            .queryParam("destinationId", "1002")
            .queryParam("operatorId", ID_1001)
            .queryParam("typeId", ID_1001)
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);

        final ObjectMapper mapper = new ObjectMapper();
        final InputStream entity = (InputStream) response.getEntity();
        final JsonNode rootNode = mapper.readTree(entity);

        Assert.assertEquals(rootNode.findValue("id").asText(), ID_1001);
        Assert.assertEquals(rootNode.findValue("operatorName").asText(), OLA);
        Assert.assertEquals(rootNode.findValue("typeName").asText(), SUV);
        Assert.assertEquals(rootNode.findValue("fare").asText(), "10.0");
        Assert.assertEquals(rootNode.findValue("discount").asText(), "2");
    }

    /**
  	 * Test case to test search by dependent id not found.
  	 * @throws Exception unknown exception
  	 */
    @Test
    public final void testSearchByDependentIdsNotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("sourceId", ID_1001)
            .queryParam("destinationId", "1002")
            .queryParam("operatorId", ID_1001)
            .queryParam("typeId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }
}
