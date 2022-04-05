package EE.filtros;

import EE.errores.ApiError;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.time.LocalDateTime;

@Provider
@Horario
public class FiltroHorarioJAX implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        LocalDateTime date = LocalDateTime.now();

        if (date.getSecond()>= 30)
        {

        }
        else
        {
            containerRequestContext.abortWith(Response.status(Response.Status.BAD_REQUEST)
                    .entity(ApiError.builder().message("error de filtro").fecha(LocalDateTime.now()).build())
                    .type(MediaType.APPLICATION_JSON_TYPE).build());
        }
    }
}
