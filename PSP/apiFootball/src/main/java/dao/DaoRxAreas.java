package dao;

import dao.modelo.Area;
import dao.modelo.AreasRequest;
import dao.modelo.Competition;
import dao.modelo.CompetitionsRequest;
import dao.retrofit.AreasAPI;
import dao.utils.ConfigurationSingleton_OkHttpClient;
import io.reactivex.rxjava3.core.Single;
import io.vavr.control.Either;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.List;

public class DaoRxAreas {

    public Single<AreasRequest> getAreas() {
//        Either<String, List<Area>> resultado = null;
//
        Retrofit retrofit = ConfigurationSingleton_OkHttpClient.getInstance();

        AreasAPI areasAPI = retrofit.create(AreasAPI.class);


        return areasAPI.loadAreas();

    }

    public Either<String, List<Competition>> getCompetitions(Area area) {
        Either<String, List<Competition>> resultado = null;

        Retrofit retrofit = ConfigurationSingleton_OkHttpClient.getInstance();

        AreasAPI areasAPI = retrofit.create(AreasAPI.class);

        Call<CompetitionsRequest> call = areasAPI.loadCompetitions(area.getId());
        try {
            Response<CompetitionsRequest> response = call.execute();
            if (response.isSuccessful())
            {
                CompetitionsRequest changesList = response.body();
                resultado = Either.right(changesList.getCompetitions());
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

//    public Either<String, List<Team>> getTeams(Competition competition,String season) {
//        Either<String, List<Team>> resultado = null;
//
//        Retrofit retrofit = ConfigurationSingleton_OkHttpClient.getInstance();
//
//        AreasAPI areasAPI = retrofit.create(AreasAPI.class);
//
//        Call<TeamsRequest> call = areasAPI.loadTeams(competition.getId(),season);
//        try {
//            Response<TeamsRequest> response = call.execute();
//            if (response.isSuccessful())
//            {
//                TeamsRequest changesList = response.body();
//                resultado = Either.right(changesList.getTeams());
//            }
//            else
//            {
//                resultado = Either.left("ERROR "+response.errorBody().toString());
//            }
//        }
//        catch (Exception e)
//        {
//            resultado= Either.left("Error de comunicacion");
//        }
//
//        return resultado;
//    }



}
