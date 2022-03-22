package com.example.roomviewmodel.ui.main

import android.util.Log
import androidx.lifecycle.*
import com.example.roomviewmodel.domain.modelo.Persona
import com.example.roomviewmodel.domain.usecases.personas.GetPersonas
import com.example.roomviewmodel.domain.usecases.personas.GetPersonasDes
import com.example.roomviewmodel.domain.usecases.personas.InsertPersona
import com.example.roomviewmodel.domain.usecases.personas.InsertPersonaWithCosas
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel (private val getPersonas: GetPersonas,
            private val insertPersona:InsertPersona,
                     private val insertPersonaWithCosas:InsertPersonaWithCosas,
                     private val getPersonasDes: GetPersonasDes,) : ViewModel(){



    private val _personas = MutableLiveData<List<Persona>>()
    val personas: LiveData<List<Persona>> get() = _personas

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error



    fun getPersonas()
    {

        viewModelScope.launch {
            _personas.value = getPersonas.invoke()

        }

    }



    fun getPersonasDes()
    {

        viewModelScope.launch {
            val personas = getPersonasDes.invoke()

            val test = getPersonasDes.invoke()

            val test2 = getPersonasDes.invokeCosas()

           _personas.value = personas

        }


    }



    fun insertPersona(persona: Persona)
    {
        viewModelScope.launch {
            insertPersona.invoke(persona)
            //_personas.value = getPersonasDes.invoke(1)
        }
    }

//    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
//        Log.e("TAG:::","test",throwable)
//    }
    fun insertPersonaWithCosas(persona: Persona)
    {
        viewModelScope.launch() {
            try {
                insertPersona.invoke(persona)
                println(persona.id)
            }
            catch(e:Exception)
            {
                _error.value = e.message
                Log.e("TAG:::",e.message,e)
            }
            //_personas.value = getPersonasDes.invoke(1)
        }
    }

}


/**
 * Factory class to instantiate the [ViewModel] instance.
 */
class MainViewModelFactory(private val getPersonas: GetPersonas,
                           private val insertPersonas: InsertPersona,
                           private val insertPersonaWithCosas:InsertPersonaWithCosas,
                           private val getPersonasDes: GetPersonasDes,)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(getPersonas,insertPersonas,insertPersonaWithCosas,getPersonasDes) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}