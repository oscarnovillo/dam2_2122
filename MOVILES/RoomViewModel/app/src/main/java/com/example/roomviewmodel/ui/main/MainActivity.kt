package com.example.roomviewmodel.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.roomviewmodel.data.PersonaRepository
import com.example.roomviewmodel.data.PersonaRoomDatabase
import com.example.roomviewmodel.databinding.ActivityMainBinding
import com.example.roomviewmodel.domain.modelo.Cosa
import com.example.roomviewmodel.domain.modelo.Persona
import com.example.roomviewmodel.domain.usecases.personas.GetPersonas
import com.example.roomviewmodel.domain.usecases.personas.GetPersonasDes
import com.example.roomviewmodel.domain.usecases.personas.InsertPersona
import com.example.roomviewmodel.domain.usecases.personas.InsertPersonaWithCosas
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var personasAdapter: PersonaAdapter


    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(
            GetPersonas(PersonaRepository(PersonaRoomDatabase.getDatabase(this).personaDao())),
            InsertPersona(PersonaRepository(PersonaRoomDatabase.getDatabase(this).personaDao())),
            InsertPersonaWithCosas(
                PersonaRepository(
                    PersonaRoomDatabase.getDatabase(this).personaDao()
                )
            ),
            GetPersonasDes(PersonaRepository(PersonaRoomDatabase.getDatabase(this).personaDao())),
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personasAdapter = PersonaAdapter()
        with(binding) {
            rvPersonas.adapter = personasAdapter

            button.setOnClickListener {
                val cosas = listOf(Cosa("cosa1", 22))
                viewModel.insertPersonaWithCosas(Persona(0, "nombre", LocalDate.now(), cosas))
                viewModel.getPersonasDes()
            }
        }

        viewModel.personas.observe(this) { personas ->
            personasAdapter.submitList(personas)
        }
        viewModel.error.observe(this) {

            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()

        }

        viewModel.getPersonas();

    }
}