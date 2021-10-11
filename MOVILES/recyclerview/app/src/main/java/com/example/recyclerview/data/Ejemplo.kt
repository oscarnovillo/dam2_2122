package com.example.recyclerview.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ejemplo(
    @Json(name = "description")
    val description: String,
    @Json(name = "extension")
    val extension: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "modified")
    val modified: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "path")
    val path: String
)