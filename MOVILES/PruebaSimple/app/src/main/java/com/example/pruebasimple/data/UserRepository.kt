package com.example.pruebasimple.data


import com.example.pruebasimple.utils.NetworkResult
import com.example.pruebasimple.data.remote.UserRemoteDataSource
import com.example.pruebasimple.domain.model.TipoUsuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Repository which fetches data from Remote or Local data sources
 */
class UserRepository @Inject constructor(
    private val movieRemoteDataSource: UserRemoteDataSource,

    ) {

    fun fetchTiposUsuario(): Flow<NetworkResult<List<TipoUsuario>>> {
        return flow {

            emit(NetworkResult.Loading())
            val result = movieRemoteDataSource.fetchTrendingMovies()

            //Cache to database if response is successful
            if (result is NetworkResult.Success) {

            }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

//    private fun fetchTrendingMoviesCached(): NetworkResult<List<Movie>> =
//            movieDao.getAll().let {list->
//                NetworkResult.Success(list.map { it.toMovie() } ?: emptyList())
//            }
//
//    fun fetchMovie(id: Int): Flow<NetworkResult<MovieDesc>> {
//        return flow {
//            emit(NetworkResult.Loading())
//            emit(movieRemoteDataSource.fetchMovie(id))
//        }.flowOn(Dispatchers.IO)
//    }
}