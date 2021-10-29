package com.example.roomviewmodel.data

import com.example.roomviewmodel.domain.Persona

class PersonaRepository(private val personaDao: PersonaDao) {

    suspend fun getPersonas() = personaDao.getPersonas()

    suspend fun getPersonasDes() = personaDao.getPersonasDes()

    suspend fun insertPersona(persona: Persona) = personaDao.insert(persona)
}