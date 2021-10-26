package com.example.roomviewmodel.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate


@Entity(tableName = "personas")
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val nombre: String,
    @ColumnInfo(name = "nacimiento")
    val nacimiento: LocalDate,
)