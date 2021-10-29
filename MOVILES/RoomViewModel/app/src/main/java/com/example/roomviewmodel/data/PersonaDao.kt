package com.example.roomviewmodel.data

import androidx.room.*
import com.example.roomviewmodel.domain.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {

    @Query("SELECT * from personas ORDER BY nombre ASC")
    suspend fun getPersonas(): List<Persona>

    @Query("SELECT * from personas ORDER BY nombre DESC")
    suspend fun getPersonasDes(): List<Persona>


    @Query("SELECT * from personas WHERE id = :id")
    fun getPersona(id: Int): Persona

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Persona)

    @Update
    fun update(item: Persona)

    @Delete
    fun delete(item: Persona)

}