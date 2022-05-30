package login.quevedo.cliente.data.network;

import com.google.gson.*;

import login.quevedo.cliente.data.CacheAuthorization;
import lombok.extern.log4j.Log4j2;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.lang.reflect.Type;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Log4j2
public class ConfigurationSingleton_OkHttpClient {
    public static OkHttpClient clientOK;

    private static Retrofit retrofit;

    private ConfigurationSingleton_OkHttpClient() {
    }

    public static synchronized Retrofit getInstance(CacheAuthorization cache) {
        if (clientOK == null) {
            CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

//            CookieJar cookieJar =
//                    new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));


            clientOK = new OkHttpClient.Builder()
                    .readTimeout(Duration.of(10, ChronoUnit.MINUTES))
                    .callTimeout(Duration.of(10, ChronoUnit.MINUTES))
                    .connectTimeout(Duration.of(10, ChronoUnit.MINUTES))
                    .addInterceptor(new AuthorizationInterceptor(cache))
                    .cookieJar(new JavaNetCookieJar(cookieManager))
                    .build();
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                @Override
                public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString());
                }
            }).registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
                        @Override
                        public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
                            return new JsonPrimitive(localDateTime.toString());
                        }
                    }
            ).create();
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://localhost:7070/Servidor-1.0-SNAPSHOT/api/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .client(clientOK)
                    .build();
        }

        return retrofit;
    }

}
