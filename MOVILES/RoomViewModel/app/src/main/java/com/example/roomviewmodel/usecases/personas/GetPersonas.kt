package com.example.roomviewmodel.usecases.personas

import com.example.roomviewmodel.data.PersonaRepository

class GetPersonas(val personasRepository: PersonaRepository) {

    suspend fun invoke() = personasRepository.getPersonas()
}