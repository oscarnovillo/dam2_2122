package com.example.recyclerview.data

import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.InputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class EjemploRepository  {


    class LocalDateTimeAdapter {
        @ToJson
        fun toJson(value: LocalDateTime): String {
            return FORMATTER.format(value)
        }

        @FromJson
        fun fromJson(value: String): LocalDateTime {
            return LocalDateTime.from(FORMATTER.parse(value))
        }

        companion object {
            private val FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss-SSSS")
        }
    }


    companion object{
        private val lista = mutableListOf<Ejemplo>()

    }


    constructor(file: InputStream){
        if (lista.size == 0)
        {
            val moshi = Moshi.Builder()
                .add(LocalDateTimeAdapter())
                .addLast(KotlinJsonAdapterFactory())
                .build()

            val ejemplo = moshi.adapter<Ejemplo>(Ejemplo::class.java).fromJson(file.bufferedReader().readText())

            ejemplo?.let{ lista.add(it)}
        }
    }

    fun getLista() : List<Ejemplo>{
        return lista
    }

}