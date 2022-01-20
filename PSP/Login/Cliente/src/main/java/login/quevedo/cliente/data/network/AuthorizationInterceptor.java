package login.quevedo.cliente.data.network;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthorizationInterceptor implements Interceptor {


    private String jwt;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request request = original.newBuilder()
                .header("Authorization", Credentials.basic("llll","password")).build();

//        Request request = original.newBuilder()
//                .header("Authorization", "Bearer "+jwt).build();

        Response response = chain.proceed(request);

        jwt = response.header("jwt");


        return response;
    }
}
