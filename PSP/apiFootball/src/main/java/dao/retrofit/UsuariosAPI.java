package dao.retrofit;

import dao.modelo.AreasRequest;
import dao.modelo.Usuario;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface UsuariosAPI {

    @GET("users/")
    Call<List<Usuario>> getUsers();


    @POST
    Single<Usuario> postUser(@Body Usuario user);

    @PUT
    Single<Usuario> putUser(@Body Usuario user);


    @DELETE("users/")
    Call<Usuario> deleteUsers(@Query("id") String id);
}
