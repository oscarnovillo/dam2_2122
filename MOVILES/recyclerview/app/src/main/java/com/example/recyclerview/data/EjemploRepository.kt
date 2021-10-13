package com.example.recyclerview.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.InputStream

class EjemploRepository  {



    companion object{
        private val lista = mutableListOf<Ejemplo>()

    }


    constructor(file: InputStream){
        if (lista.size == 0)
        {
            val moshi = Moshi.Builder()
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