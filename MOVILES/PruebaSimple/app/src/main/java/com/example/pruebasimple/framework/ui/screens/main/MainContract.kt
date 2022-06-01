package com.example.pruebasimple.framework.ui.screens.main

import com.example.pruebasimple.domain.model.TipoUsuario


interface MainContract {

    sealed class Event {

        object PedirDatos : Event()
        object MensajeMostrado: Event()


    }

    data class State(
        val users: List<TipoUsuario> = emptyList(),
        val isLoading : Boolean = false,
        val error: String? = null,

    )
}