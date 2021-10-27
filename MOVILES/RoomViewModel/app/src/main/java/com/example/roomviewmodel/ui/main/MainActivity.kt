package com.example.roomviewmodel.ui.main

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.roomviewmodel.R
import com.example.roomviewmodel.data.PersonaRepository
import com.example.roomviewmodel.data.PersonaRoomDatabase
import com.example.roomviewmodel.domain.Persona
import com.example.roomviewmodel.usecases.personas.GetPersonas
import com.example.roomviewmodel.usecases.personas.InsertPersona
import java.time.LocalDate

class MainActivity : AppCompatActivity() {


    private val viewModel: MainViewModel by viewModels{
        MainViewModelFactory(
            GetPersonas( PersonaRepository(PersonaRoomDatabase.getDatabase(this).personaDao())),
                InsertPersona( PersonaRepository(PersonaRoomDatabase.getDatabase(this).personaDao()))
        )
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.insertPersona(Persona("nombre", LocalDate.now()))

        viewModel.personas.observe(this,{ personas->

            println(personas)

        })

        viewModel.getPersonas();



    }
}