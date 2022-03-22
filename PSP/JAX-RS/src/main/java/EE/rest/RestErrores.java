package EE.rest;


import jakarta.ws.rs.*;
import servicios.ServiciosErrores;
import dao.modelo.Usuario;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/errores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestErrores {

    private ServiciosErrores su;



    @Inject
    public RestErrores(ServiciosErrores su) {
        this.su = su;
    }


    @GET
    public List<Usuario> getAllUsuario() {
        return su.dameTodos();
    }

    @GET
    @Path("/{id}")
    public Usuario getUsuario(@PathParam("id") String id) {
        return su.dameUsuario(id);
    }


}
