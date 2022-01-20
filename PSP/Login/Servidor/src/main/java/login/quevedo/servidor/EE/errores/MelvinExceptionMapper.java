package login.quevedo.servidor.EE.errores;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import login.quevedo.servidor.domain.errores.CustomException;
import login.quevedo.servidor.domain.errores.MelvinException;

@Provider
public class MelvinExceptionMapper  implements ExceptionMapper<MelvinException> {


    @Override
    public Response toResponse(MelvinException e) {
        return Response.status(Response.Status.NO_CONTENT).entity("Hola melvin")
                .type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
