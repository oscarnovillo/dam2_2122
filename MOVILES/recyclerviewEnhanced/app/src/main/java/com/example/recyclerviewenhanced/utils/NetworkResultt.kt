package com.example.recyclerviewenhanced.utils

sealed class NetworkResultt<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : NetworkResultt<T>(data)

    class Error<T>(message: String, data: T? = null) : NetworkResultt<T>(data, message)

    class Loading<T> : NetworkResultt<T>()

}