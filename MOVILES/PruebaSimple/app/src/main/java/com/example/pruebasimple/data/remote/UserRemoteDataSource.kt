package com.example.pruebasimple.data.remote

import com.example.pruebasimple.utils.NetworkResult
import com.example.pruebasimple.domain.model.TipoUsuario
import com.example.pruebasimple.network.services.UserService
import javax.inject.Inject

/**
 * fetches data from remote source
 */
class UserRemoteDataSource @Inject constructor(private val userService: UserService) :
    BaseApiResponse() {

    suspend fun fetchTrendingMovies(): NetworkResult<List<TipoUsuario>> {

        return safeApiCall(apiCall = { userService.getTiposUsuario() })

    }


//    private suspend fun <T> getResponse(request: suspend () -> Response<T>, defaultErrorMessage: String): Result<T> {
//        return try {
//            println("I'm working in thread ${Thread.currentThread().name}")
//            val result = request.invoke()
//            if (result.isSuccessful) {
//                return Result.success(result.body())
//            } else {
//                val errorResponse = ErrorUtils.parseError(result, retrofit)
//                Result.error(errorResponse?.status_message ?: defaultErrorMessage, errorResponse)
//            }
//        } catch (e: Throwable) {
//            Result.error("Unknown Error", null)
//        }
//    }
}