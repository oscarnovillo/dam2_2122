package login.quevedo.servidor.EE.rest;


import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import login.quevedo.servidor.modelo.Alumno;

@Path("/alumnno")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestAlumnos {



    @GET
    @RolesAllowed("user")
    public Alumno get()
    {
        return Alumno.builder().nombre("kkk").build();
    }

}
