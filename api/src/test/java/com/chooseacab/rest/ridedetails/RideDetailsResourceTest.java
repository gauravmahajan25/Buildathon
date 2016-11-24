package com.chooseacab.rest.ridedetails;

import com.chooseacab.rest.AbstractTestNGJerseyDBUnitTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InputStream;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RideDetailsResourceTest extends AbstractTestNGJerseyDBUnitTest {

    @Override
    public String getDataSetFileName() {
        return "dataset/RideDetailsResourceTest_DBUnit.xml"; }

    @Override
    protected Class[] resourcesToRegister() {
        return new Class[]{RideDetailsResource.class};
    }

    @Test
    public void test_endpointName() {
        final String endpointName = RideDetailsResource.RESOURCE_IDENTIFIER;
        Assert.assertEquals(endpointName, "/ride-details");
    }

    @Test
    public void test_search() throws Exception {
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

    @Test
    public void test_searchBySourceId() throws Exception {
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

    @Test
    public void test_searchBySourceId_NotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("sourceId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    @Test
    public void test_searchByDestinationId() throws Exception {
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

    @Test
    public void test_searchByDestinationId_NotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("destinationId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    @Test
    public void test_searchByOperatorId() throws Exception {
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

    @Test
    public void test_searchByOperatorId_NotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("operatorId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    @Test
    public void test_searchByTypeId() throws Exception {
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

    @Test
    public void test_searchByTypeId_NotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("typeId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }

    @Test
    public void test_searchBySourceAndDestinationAndOperatorAndTypeId() throws Exception {
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

    @Test
    public void test_searchBySourceAndDestinationAndOperatorAndTypeId_NotFound() throws Exception {
        final Response response  = target(RideDetailsResource.RESOURCE_IDENTIFIER)
            .queryParam("sourceId", "1001")
            .queryParam("destinationId", "1002")
            .queryParam("operatorId", "1001")
            .queryParam("typeId", "1003")
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.NOT_FOUND);
    }
}
