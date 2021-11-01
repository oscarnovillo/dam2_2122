package EE.rest;


import EE.errores.ApiError;
import EE.filtros.Filtered;
import EE.filtros.Reader;
import EE.filtros.Writer;
import dao.modelo.Usuario;
import dao.modelo.UsuarioGetDTO;
import org.modelmapper.ModelMapper;
import servicios.ServiciosUsuarios;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestUsuarios {

    private ServiciosUsuarios su;

    private ModelMapper mapper;

    @Inject
    public RestUsuarios(ServiciosUsuarios su, ModelMapper mapper) {
        this.su = su;
        this.mapper = mapper;
    }

    //para todos los metodos
    //@Context HttpServletRequest request;

    @GET
    @Filtered
    @Path("/uno")
    public Response getUsuario(@QueryParam("id") String id,
                               @Context HttpServletRequest request) {

        AtomicReference<Response> r = new AtomicReference();
        su.dameUno(id)
                .peek(usuario -> r.set(Response.ok(usuario).build()))
                .peekLeft(apiError -> r.set(Response.status(Response.Status.NOT_FOUND)
                        .entity(apiError)
                        .build()));

        return r.get();

    }

    @GET
    @Writer
    @Path("/{id}")
    public Response getUnUsuario(@PathParam("id") String id,
                                @HeaderParam("kk") String head) {
        AtomicReference<Response> r = new AtomicReference();
        su.dameUno(id)
                .peek(usuario -> r.set(Response.ok().entity(usuario).build()))
                .peekLeft(apiError -> r.set(Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiError("error not found", LocalDateTime.now()))
                        .build()));

        return r.get();
    }

    @GET
    public List<Usuario> getAllUsuario() {
        return su.dameTodos();
    }

    @POST
    @Reader
    public Usuario addUsuario(Usuario user) {
        return su.addUser(user);
    }

    @DELETE
    public Usuario delUsuario(Usuario user) {
        return user;
    }
}
