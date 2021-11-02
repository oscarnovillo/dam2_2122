package com.example.roomviewmodel.usecases.personas

import com.example.roomviewmodel.data.PersonaRepository

class GetPersonasDes(val personasRepository: PersonaRepository) {

    suspend fun invoke(id:Int) =
        personasRepository.getPersonaWithCosas(id)


    suspend fun invoke() =
        personasRepository.getPersonaWithCosas()


    suspend fun invokeCosas() =
        personasRepository.getCosas()
}