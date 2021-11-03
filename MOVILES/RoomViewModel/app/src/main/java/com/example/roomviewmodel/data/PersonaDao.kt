package com.example.roomviewmodel.data

import androidx.room.*
import com.example.roomviewmodel.domain.Cosa
import com.example.roomviewmodel.domain.Persona
import com.example.roomviewmodel.domain.PersonaWithCosas
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {

    @Query("SELECT * from personas ORDER BY nombre ASC")
    suspend fun getPersonas(): List<Persona>

    @Query("SELECT * from personas ORDER BY nombre DESC")
    suspend fun getPersonasDes(): List<Persona>

    @Query("SELECT * from cosas")
    suspend fun getCosas(): List<Cosa>

    @Transaction
    @Query("SELECT * FROM personas WHERE id = :id")
    suspend fun getPersonaWithCosas(id: Int): PersonaWithCosas

    @Transaction
    @Query("SELECT * FROM personas")
    suspend fun getPersonaWithCosas(): List<PersonaWithCosas>

    @Query("SELECT * from personas WHERE id = :id")
    fun getPersona(id: Int): Persona

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Persona) : Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Cosa)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: List<Cosa>)

    @Transaction
    suspend fun createTransaction(personaCosas: PersonaWithCosas) {
        personaCosas.persona.id = insert(personaCosas.persona).toInt()
        personaCosas.cosa.forEach { it.personaId = personaCosas.persona.id  }
        insert(personaCosas.cosa)
    }

    @Update
    fun update(item: Persona)

    @Delete
    fun delete(item: Persona)

}