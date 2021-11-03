package com.example.roomviewmodel.domain

import java.time.LocalDateTime

data class PersonaUI(
    val id: Int,
    val nombre: String,
    val nacimiento: LocalDateTime,
    val cosas: List<Cosa>
)
