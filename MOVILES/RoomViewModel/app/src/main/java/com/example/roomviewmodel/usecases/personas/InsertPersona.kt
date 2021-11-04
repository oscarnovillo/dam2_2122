package com.example.roomviewmodel.usecases.personas

import com.example.roomviewmodel.data.PersonaRepository
import com.example.roomviewmodel.data.modelo.PersonaEntity
import com.example.roomviewmodel.data.modelo.PersonaWithCosas
import com.example.roomviewmodel.data.modelo.toPersonaEntity
import com.example.roomviewmodel.data.modelo.toPersonaWithCosas
import com.example.roomviewmodel.domain.Persona

class InsertPersona(val personasRepository: PersonaRepository) {

    suspend fun invoke(persona: Persona) = personasRepository.insertPersona(persona.toPersonaEntity())
}