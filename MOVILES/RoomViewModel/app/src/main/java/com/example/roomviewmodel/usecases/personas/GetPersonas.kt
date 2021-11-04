package com.example.roomviewmodel.usecases.personas

import com.example.roomviewmodel.data.PersonaRepository
import com.example.roomviewmodel.data.modelo.toPersona

class GetPersonas(val personasRepository: PersonaRepository) {

     suspend fun invoke() = personasRepository.getPersonas().map { it.toPersona() }
}