package com.example.flows.framework.utils

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
//    object Retrying : UiState<Nothing>()
//    object SwipeRefreshing : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Failure(val mensaje: String) : UiState<Nothing>()
//    data class SwipeRefreshFailure(val exception: Exception) : UiState<Nothing>()
}

val <T> UiState<T>.successData: T
    get() = (this as UiState.Success).data