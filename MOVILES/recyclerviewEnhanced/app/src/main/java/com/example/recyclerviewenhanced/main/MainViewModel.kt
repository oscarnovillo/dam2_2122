package com.example.recyclerviewenhanced.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewenhanced.domain.Persona
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {


    private val listaPersonas = mutableListOf<Persona>()

    private val _personas = MutableLiveData<List<Persona>>()
    val personas: LiveData<List<Persona>> get() = _personas

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error



    init {

        listaPersonas.addAll(listOf<Persona>(
            Persona(1,"nombre", LocalDate.now(),null),
            Persona(2,"nombre1", LocalDate.now(),null),
            Persona(3,"nombre2", LocalDate.now(),null),
        ))

    }

    fun getPersonas() {

        viewModelScope.launch {

            _personas.value = listaPersonas.toList()
//            _personas.value = getPersonas.invoke()

        }

    }

    fun getPersonas(filtro:String) {

        viewModelScope.launch {

            _personas.value = listaPersonas.filter { it.nombre.startsWith(filtro) }.toList()
//            _personas.value = getPersonas.invoke()

        }

    }


    fun deletePersona(persona: List<Persona>) {

        viewModelScope.launch {

            listaPersonas.removeAll(persona)
            _personas.value = listaPersonas.toList()
//            _personas.value = getPersonas.invoke()

        }

    }

    fun deletePersona(persona: Persona) {

        viewModelScope.launch {

            listaPersonas.remove(persona)
            _personas.value = listaPersonas.toList()
//            _personas.value = getPersonas.invoke()

        }

    }



}