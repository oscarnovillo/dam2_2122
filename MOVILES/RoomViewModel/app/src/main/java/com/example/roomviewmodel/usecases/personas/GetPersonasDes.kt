package com.example.roomviewmodel.usecases.personas

import com.example.roomviewmodel.data.PersonaRepository

class GetPersonasDes(val personasRepository: PersonaRepository) {

    suspend fun invoke() = personasRepository.getPersonasDes()
}