package com.chooseacab.rest.location;

import com.chooseacab.rest.AbstractTestNGJerseyDBUnitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class LocationResourceTest extends AbstractTestNGJerseyDBUnitTest {

    @Override
    public String getDataSetFileName() {
        return "dataset/LocationResourceTest_DBUnit.xml"; }

    @Override
    protected Class[] resourcesToRegister() {
        return new Class[]{LocationResource.class};
    }

    @Test
    public void test_endpointName() {
        final String endpointName = LocationResource.RESOURCE_IDENTIFIER;
        Assert.assertEquals(endpointName, "/location");
    }

    @Test
    public void test_getAllLocations() throws Exception {
        final Response response  = target(LocationResource.RESOURCE_IDENTIFIER)
            .request().accept(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.fromStatusCode(response.getStatus()), Response.Status.OK);
    }
}
