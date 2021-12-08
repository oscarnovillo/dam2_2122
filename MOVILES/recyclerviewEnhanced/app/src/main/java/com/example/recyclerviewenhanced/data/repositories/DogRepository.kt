package com.example.recyclerviewenhanced.data.repositories

import com.example.recyclerviewenhanced.data.model.DogResponse
import com.example.recyclerviewenhanced.utils.NetworkResult
import com.example.recyclerviewenhanced.data.sources.remote.RemoteDataSource

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


@ActivityRetainedScoped
class DogRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
)  {

    suspend fun getDog() = withContext(Dispatchers.IO){ remoteDataSource.getDog() }



}

