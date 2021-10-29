package com.example.roomviewmodel.ui.main

import androidx.lifecycle.*
import com.example.roomviewmodel.domain.Persona
import com.example.roomviewmodel.usecases.personas.GetPersonas
import com.example.roomviewmodel.usecases.personas.GetPersonasDes
import com.example.roomviewmodel.usecases.personas.InsertPersona
import kotlinx.coroutines.launch

class MainViewModel (private val getPersonas: GetPersonas,
            private val insertPersona:InsertPersona,
                     private val getPersonasDes: GetPersonasDes,) : ViewModel(){



    private val _personas = MutableLiveData<List<Persona>>()
    val personas: LiveData<List<Persona>> get() = _personas



    fun getPersonas()
    {

        viewModelScope.launch {
            _personas.value = getPersonas.invoke()

        }


    }



    fun getPersonasDes()
    {

        viewModelScope.launch {
            _personas.value = getPersonasDes.invoke()

        }


    }

    fun insertPersona(persona:Persona)
    {
        viewModelScope.launch {
            insertPersona.invoke(persona)
            _personas.value = getPersonasDes.invoke()
        }
    }


}


/**
 * Factory class to instantiate the [ViewModel] instance.
 */
class MainViewModelFactory(private val getPersonas: GetPersonas,
                           private val insertPersonas: InsertPersona,
                           private val getPersonasDes: GetPersonasDes,)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(getPersonas,insertPersonas,getPersonasDes) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}