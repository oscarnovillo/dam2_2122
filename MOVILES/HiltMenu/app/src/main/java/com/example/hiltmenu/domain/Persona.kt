package com.example.roomviewmodel.domain

import com.example.roomviewmodel.data.modelo.CosaEntity
import java.time.LocalDate
import java.time.LocalDateTime

data class Persona(
    val id: Int,
    val nombre: String,
    val nacimiento: LocalDate,
    val cosas: List<Cosa>?
)
