package com.example.recyclerviewenhanced.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewenhanced.domain.Cosa
import com.example.recyclerviewenhanced.domain.Persona
import com.example.hiltmenu.ui.main.PersonaAdapter
import com.example.recyclerviewenhanced.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var personasAdapter: PersonaAdapter


    private val viewModel: MainViewModel by viewModels()
    /*{
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
    }*/



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        personasAdapter = PersonaAdapter()
        binding.rvPersonas.adapter = personasAdapter

        binding.button.setOnClickListener {
            val cosas = listOf(Cosa("cosa1", 22))
            println(personasAdapter.getSelectedItems().toString())
//            viewModel.insertPersonaWithCosas(Persona(0, "nombre", LocalDate.now(), cosas))
            viewModel.getPersonas()
        }

        viewModel.personas.observe(this, { personas ->

            personasAdapter.submitList(personas)
        })
        viewModel.error.observe(this, {

            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()

        })

        viewModel.getPersonas();

    }
}