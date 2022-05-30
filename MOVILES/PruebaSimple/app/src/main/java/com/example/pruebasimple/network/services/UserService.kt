package io.buildwithnd.demotmdb.network.services

import com.example.pruebasimple.domain.model.TipoUsuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit API Service
 */
interface UserService {

    @GET("/api/usuarios/allTipos")
    suspend fun getTiposUsuario() : Response<List<TipoUsuario>>

}