package login.quevedo.cliente.data;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.vavr.control.Either;
import login.quevedo.cliente.data.modelo.Alumno;
import login.quevedo.cliente.data.network.ConfigurationSingleton_OkHttpClient;
import login.quevedo.cliente.data.servicios.EstupidoAPI;

public class DaoEstupido extends DaoGenerics{


    public Single<Either<String,Alumno>> getAlumno(){
        EstupidoAPI estu = ConfigurationSingleton_OkHttpClient.getInstance().create(EstupidoAPI.class);

        return safeSingleApicall(estu.getAlumno())
                //.map(either -> either.map(alumno -> alumno.setNombre("mapeado")))
                .subscribeOn(Schedulers.io());

    }

}
