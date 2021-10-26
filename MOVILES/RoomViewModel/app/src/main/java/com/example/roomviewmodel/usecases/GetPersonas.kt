package com.example.roomviewmodel.usecases

import com.example.roomviewmodel.data.PersonaRepository

class GetPersonas(val personasRepository: PersonaRepository) {

    fun invoke() = personasRepository.getPersonas()
}