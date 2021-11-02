package com.example.roomviewmodel.data

import com.example.roomviewmodel.domain.Persona
import com.example.roomviewmodel.domain.PersonaWithCosas

class PersonaRepository(private val personaDao: PersonaDao) {

    suspend fun getPersonas() = personaDao.getPersonas()

    suspend fun getCosas() = personaDao.getCosas()

    suspend fun getPersonasDes() = personaDao.getPersonasDes()

    suspend fun getPersonaWithCosas(id:Int) = personaDao.getPersonaWithCosas(id)

    suspend fun getPersonaWithCosas() = personaDao.getPersonaWithCosas()

    suspend fun insertPersona(persona: Persona) = personaDao.insert(persona)

    suspend fun insertPersonaEntera(persona: PersonaWithCosas) = personaDao.createTransaction(persona)
}