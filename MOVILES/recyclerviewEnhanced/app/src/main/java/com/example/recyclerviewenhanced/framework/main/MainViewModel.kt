package com.example.recyclerviewenhanced.framework.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewenhanced.data.repositories.DogRepository
import com.example.recyclerviewenhanced.domain.Persona
import com.example.recyclerviewenhanced.utils.NetworkResultt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val dogRepository: DogRepository) : ViewModel() {


    private val listaPersonas = mutableListOf<Persona>()

    private val _personas = MutableLiveData<List<Persona>>()
    val personas: LiveData<List<Persona>> get() = _personas

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()


    init {

        listaPersonas.addAll(
            listOf<Persona>(
                Persona(1, "nombre", LocalDate.now(), null),
                Persona(2, "nombre1", LocalDate.now(), null),
                Persona(3, "nombre2", LocalDate.now(), null),
            )
        )

    }

    fun getPersonas() {

        viewModelScope.launch {

            var result = dogRepository.getDog()


            when (result) {
                is NetworkResultt.Error -> _error.value = result.message ?: ""
                is NetworkResultt.Loading -> TODO()
                is NetworkResultt.Success -> listaPersonas[0].nombre = result.data?.message ?: ""
            }

            result = dogRepository.getDog()

            when (result) {
                is NetworkResultt.Error -> _error.value = result.message ?: ""
                is NetworkResultt.Loading -> TODO()
                is NetworkResultt.Success -> listaPersonas[1].nombre = result.data?.message ?: ""
            }


            _personas.value = listaPersonas.toList()
//            _personas.value = getPersonas.invoke()

        }

    }

    fun getPersonas(filtro: String) {

        viewModelScope.launch {

            _personas.value = listaPersonas.filter { it.nombre.startsWith(filtro) }.toList()
//            _personas.value = getPersonas.invoke()

        }

    }


    fun deletePersona(persona: List<Persona>) {

        viewModelScope.launch {
            _sharedFlow.emit("error")
//            listaPersonas.removeAll(persona)
//            _personas.value = listaPersonas.toList()
//            _personas.value = getPersonas.invoke()

        }

    }

    fun deletePersona(persona: Persona) {

        viewModelScope.launch {
            _sharedFlow.emit("error")
//            listaPersonas.remove(persona)
//            _personas.value = listaPersonas.toList()
//            _personas.value = getPersonas.invoke()

        }

    }


}