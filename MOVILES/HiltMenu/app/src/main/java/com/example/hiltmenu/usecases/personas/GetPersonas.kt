package com.example.hiltmenu.usecases.personas

import com.example.hiltmenu.data.PersonaRepository
import com.example.hiltmenu.data.modelo.toPersona
import javax.inject.Inject

class GetPersonas @Inject constructor(val personasRepository: PersonaRepository) {

     suspend fun invoke() = personasRepository.getPersonas().map { it.toPersona() }
}