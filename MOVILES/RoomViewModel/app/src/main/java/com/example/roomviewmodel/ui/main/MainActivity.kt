package com.example.roomviewmodel.ui.main

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import com.example.roomviewmodel.R
import com.example.roomviewmodel.data.PersonaRepository
import com.example.roomviewmodel.data.PersonaRoomDatabase
import com.example.roomviewmodel.databinding.ActivityMainBinding
import com.example.roomviewmodel.domain.Persona
import com.example.roomviewmodel.usecases.personas.GetPersonas
import com.example.roomviewmodel.usecases.personas.InsertPersona
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var personasAdapter: PersonaAdapter


    private val viewModel: MainViewModel by viewModels{
        MainViewModelFactory(
            GetPersonas( PersonaRepository(PersonaRoomDatabase.getDatabase(this).personaDao())),
                InsertPersona( PersonaRepository(PersonaRoomDatabase.getDatabase(this).personaDao()))
        )
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        personasAdapter = PersonaAdapter()
        binding.rvPersonas.adapter = personasAdapter


        binding.button.setOnClickListener {
            viewModel.insertPersona(Persona("nombre", LocalDate.now()))
        }

        viewModel.personas.observe(this,{ personas->

            personasAdapter.submitList(personas)
        })

        viewModel.getPersonas();

    }
}