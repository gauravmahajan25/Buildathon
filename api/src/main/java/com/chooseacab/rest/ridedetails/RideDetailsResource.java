package com.chooseacab.rest.ridedetails;

import com.chooseacab.platform.exception.NoSuchEntityException;
import com.chooseacab.platform.exception.SystemMessage;
import com.chooseacab.search.RideDetailsSearch;
import com.chooseacab.util.ResourceBundleEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Ride Details Resource. Handles all CRUD(Create/Update/Read/Delete) operations for http requests.
 */
@Path(RideDetailsResource.RESOURCE_IDENTIFIER)
@Component(value = "rideDetailsResource")
public class RideDetailsResource {

  private static final String RESOURCE_NAME = "ride-details";

  public static final String RESOURCE_IDENTIFIER = "" + "/" + RESOURCE_NAME;

  private static final Logger LOGGER = LoggerFactory.getLogger(RideDetailsResource.class);

  @Autowired
  private MessageSource messageSource;

  @Context
  private UriInfo uriInfo;

  @Autowired
  private RideDetailsRepresentationService rideDetailsRepresentationService;
  /**
   * provides ride details based on source, destination and operator selection.
   * @param sourceId source location id
   * @param destinationId destination location id
   * @param operatorIds operator id
   * @param typeIds type id
   * @return ride details response
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response search(@QueryParam("sourceId") final Long sourceId,
                                  @QueryParam("destinationId") final Long destinationId,
                                  @QueryParam("operatorId") final Set<Long> operatorIds,
                                  @QueryParam("typeId") final Set<Long> typeIds) {

    try {
      final RideDetailsSearch rideDetailsSearch = new RideDetailsSearch(sourceId, destinationId,
                                                                        operatorIds, typeIds);
      final List<RideDetailsRepresentation>
          representations =
          rideDetailsRepresentationService.searchRideDetails(rideDetailsSearch);

      if (representations.isEmpty()) {
        final SystemMessage message =
            SystemMessage.createSystemMessage(messageSource,
                                              ResourceBundleEnum.NOT_FOUND);
        return Response.status(Response.Status.NOT_FOUND).type(MediaType.APPLICATION_JSON_TYPE)
            .entity(message).build();
      }

      return Response.status(Response.Status.OK)
          .type(MediaType.APPLICATION_JSON)
          .entity(representations)
          .build();
    } catch (NoSuchEntityException enfe) {
      LOGGER.error("Failed due to No such entity found exception", enfe);
      final SystemMessage message = SystemMessage.createSystemMessage(messageSource,
                                                                      ResourceBundleEnum.NOT_FOUND);
      return Response.status(Response.Status.NOT_FOUND).type(MediaType.APPLICATION_JSON_TYPE)
          .entity(message).build();

    } catch (Exception e) {
      LOGGER.error("Exception occurred while Getting Ride Details:", e);
      SystemMessage
          message =
          SystemMessage.createSystemMessage(messageSource, ResourceBundleEnum.DEFAULT);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(
          MediaType.APPLICATION_JSON_TYPE).entity(message).build();
    }
  }
}