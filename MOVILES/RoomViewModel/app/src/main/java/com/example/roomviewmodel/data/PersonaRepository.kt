package com.example.roomviewmodel.data

class PersonaRepository(private val personaDao: PersonaDao) {

    fun getPersonas() = personaDao.getItems()
}