package com.chooseacab.rest.location;

import com.chooseacab.platform.exception.NoSuchEntityException;
import com.chooseacab.platform.exception.SystemMessage;
import com.chooseacab.util.ResourceBundleEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Location Resource. Handles all CRUD(Create/Update/Read/Delete) operations for http requests.
 */
@Path(LocationResource.RESOURCE_IDENTIFIER)
@Component(value = "locationResource")
public class LocationResource {

  private static final String RESOURCE_NAME = "location";

  public static final String RESOURCE_IDENTIFIER = "/" + RESOURCE_NAME;

  private static final Logger LOGGER = LoggerFactory.getLogger(LocationResource.class);

  @Autowired
  private MessageSource messageSource;

  @Autowired
  private LocationRepresentationService locationRepresentationService;

  /**
   * Get All locations
   * @return response Response Builder
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllLocations() {

    Response response = null;
    try {
      List<LocationRepresentation>
          representations =
          locationRepresentationService.getAllLocations();

      if (representations.isEmpty()) {
        final SystemMessage message =
            SystemMessage.createSystemMessage(messageSource,
                                              ResourceBundleEnum.NOT_FOUND);
        response =  Response.status(Response.Status.NOT_FOUND).type(MediaType.APPLICATION_JSON_TYPE)
            .entity(message).build();
      }

      response = Response.status(Response.Status.OK)
          .type(MediaType.APPLICATION_JSON)
          .entity(representations)
          .build();
    } catch (NoSuchEntityException enfe) {
      LOGGER.error("Failed due to No such entity found exception", enfe);
      final SystemMessage message = SystemMessage.createSystemMessage(messageSource,
                                                                      ResourceBundleEnum.NOT_FOUND);
      response = Response.status(Response.Status.NOT_FOUND).type(MediaType.APPLICATION_JSON_TYPE)
          .entity(message).build();

    } catch (Exception e) {
      LOGGER.error("Exception occurred while Getting locations:", e);
      SystemMessage
          message =
          SystemMessage.createSystemMessage(messageSource, ResourceBundleEnum.DEFAULT);
      response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(
          MediaType.APPLICATION_JSON_TYPE).entity(message).build();
    }

    return response;
  }

  /**
   * Get Message source
   * @return
   */
  public MessageSource getMessageSource() {
    return messageSource;
  }

  /**
   * Set Message source
   * @param messageSource
   */
  public void setMessageSource(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  /**
   * Get Location representation service
   * @return
   */
  public LocationRepresentationService getLocationRepresentationService() {
    return locationRepresentationService;
  }

  /**
   * Set Location representation service
   * @param locationRepresentationService
   */
  public void setLocationRepresentationService(LocationRepresentationService locationRepresentationService) {
    this.locationRepresentationService = locationRepresentationService;
  }
}