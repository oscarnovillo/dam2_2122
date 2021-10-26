package com.example.roomviewmodel.data

import androidx.room.*
import com.example.roomviewmodel.domain.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {

    @Query("SELECT * from personas ORDER BY name ASC")
    fun getItems(): List<Persona>

    @Query("SELECT * from personas WHERE id = :id")
    fun getItem(id: Int): Persona

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: Persona)

    @Update
    fun update(item: Persona)

    @Delete
    fun delete(item: Persona)

}