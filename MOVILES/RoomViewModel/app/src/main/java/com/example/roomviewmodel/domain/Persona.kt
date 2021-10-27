package com.example.roomviewmodel.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate


@Entity(tableName = "personas")
data class Persona(

    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "nacimiento")
    val nacimiento: LocalDate,
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
)