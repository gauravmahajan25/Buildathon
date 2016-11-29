package com.chooseacab.rest.type;

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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.lang.invoke.MethodHandles;
import java.util.List;

/**
 * Type Resource. Handles all CRUD(Create/Update/Read/Delete) operations for http requests.
 */
@Path(TypeResource.RESOURCE_IDENTIFIER)
@Component(value = "typeResource")
public class TypeResource {

  private static final String RESOURCE_NAME = "type";

  public static final String RESOURCE_IDENTIFIER = "/" + RESOURCE_NAME;

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @Autowired
  private static MessageSource messageSource;

  @Context
  private UriInfo uriInfo;

  @Autowired
  private static TypeRepresentationService typeRepresentationService;

  /**
   * Get Types.
   * @return response response.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getTypes() {

    try {
      List<TypeRepresentation> representations = typeRepresentationService.getTypes();

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
      LOGGER.error("Exception occurred while Getting Types:", e);
      SystemMessage
          message =
          SystemMessage.createSystemMessage(messageSource, ResourceBundleEnum.DEFAULT);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(
          MediaType.APPLICATION_JSON_TYPE).entity(message).build();
    }
  }
}