package com.example.roomviewmodel.domain

import androidx.room.Embedded
import androidx.room.Relation


data class PersonaWithCosas(
    @Embedded val persona: Persona,
    @Relation(
        parentColumn = "id",
        entityColumn = "personaId"
    )
    val cosa: List<Cosa>

)