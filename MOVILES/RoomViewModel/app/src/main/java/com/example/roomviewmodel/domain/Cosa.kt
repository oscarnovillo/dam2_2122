package com.example.roomviewmodel.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.NO_ACTION
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "cosas",
foreignKeys = [
    ForeignKey(entity = Persona::class,
        parentColumns = ["id"],
        childColumns = ["personaId"])
        ])
data class Cosa(
    @ColumnInfo(name = "nombre")
    val nombre: String,
    var personaId: Int=0,
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
)