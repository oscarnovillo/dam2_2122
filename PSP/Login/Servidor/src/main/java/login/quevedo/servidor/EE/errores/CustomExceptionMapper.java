package login.quevedo.servidor.EE.errores;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import login.quevedo.servidor.domain.errores.CustomException;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Provider
public class CustomExceptionMapper implements ExceptionMapper<CustomException> {

  public Response toResponse(CustomException exception) {
    ApiError apiError = new ApiError(exception.getMessage(), LocalDateTime.now());
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(apiError)
        .type(MediaType.APPLICATION_JSON_TYPE).build();
  }

}
