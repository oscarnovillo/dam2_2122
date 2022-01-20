package login.quevedo.cliente.data.servicios;

import io.reactivex.rxjava3.core.Single;
import login.quevedo.cliente.data.modelo.Alumno;
import retrofit2.http.GET;

public interface EstupidoAPI {


    @GET("alumno")
    Single<Alumno> getAlumno();
}
