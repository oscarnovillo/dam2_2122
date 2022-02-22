package com.example.springkotlin.domain.model

data class Pokemon(val nombre:String, val generacion: String, val habilidades: List<String>, val caracteristicasInutiles: String,
                   var id:Int = 0)

