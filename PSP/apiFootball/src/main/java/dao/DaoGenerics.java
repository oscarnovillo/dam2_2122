package dao;

import dao.modelo.Competition;
import dao.modelo.CompetitionsRequest;
import dao.retrofit.AreasAPI;
import dao.utils.ConfigurationSingleton_OkHttpClient;
import io.vavr.control.Either;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.List;

abstract class DaoGenerics {

    public <T> Either<String, T> safeApicall(Call<T> call){
        Either<String, T> resultado = null;

        try {
            Response<T> response = call.execute();
            if (response.isSuccessful())
            {
                resultado = Either.right(response.body());
            }
            else
            {
                resultado = Either.left(response.errorBody().toString());
            }
        }
        catch (Exception e)
        {
            resultado= Either.left("Error de comunicacion");

        }

        return resultado;
    }
}
