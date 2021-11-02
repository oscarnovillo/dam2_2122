package com.example.roomviewmodel.usecases.personas

import com.example.roomviewmodel.data.PersonaRepository
import com.example.roomviewmodel.domain.Persona
import com.example.roomviewmodel.domain.PersonaWithCosas

class InsertPersona(val personasRepository: PersonaRepository) {

    suspend fun invoke(persona: Persona) = personasRepository.insertPersona(persona)

    suspend fun invoke(persona: PersonaWithCosas) = personasRepository.insertPersonaEntera(persona)
}