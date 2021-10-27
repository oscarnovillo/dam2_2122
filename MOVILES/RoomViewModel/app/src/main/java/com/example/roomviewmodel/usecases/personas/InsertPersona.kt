package com.example.roomviewmodel.usecases.personas

import com.example.roomviewmodel.data.PersonaRepository
import com.example.roomviewmodel.domain.Persona

class InsertPersona(val personasRepository: PersonaRepository) {

    suspend fun invoke(persona: Persona) = personasRepository.insertPersona(persona)
}