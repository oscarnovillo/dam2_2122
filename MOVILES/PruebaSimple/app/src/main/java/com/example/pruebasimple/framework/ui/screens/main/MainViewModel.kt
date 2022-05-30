package com.example.pruebasimple.framework.ui.screens.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebasimple.data.UserRepository
import com.example.pruebasimple.framework.ui.screens.main.MainContract.*
import com.example.pruebasimple.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {



    init {
        pedirDatos()
    }

    private val _uiState: MutableStateFlow<State> by lazy {
        MutableStateFlow(State())
    }
    val uiState: StateFlow<State> = _uiState

    fun handleEvent(event: Event) {
        when (event) {
            Event.PedirDatos -> {
                pedirDatos()
            }
            Event.MensajeMostrado -> {
                _uiState.update { it.copy(error = null) }
            }
        }
    }

    private fun pedirDatos() {
        viewModelScope.launch {
            userRepository.fetchTiposUsuario()
                .catch(action = { cause ->  _uiState.update { it.copy(error = cause.message ?: "") }})
                .collect { result ->
                    when (result) {
                        is NetworkResult.Error -> {
                            _uiState.update { it.copy(error = result.message) }
                            //_uiError.send(result.message ?: "Error")
                        }
                        is NetworkResult.Loading -> _uiState.update { it.copy(isLoading = true) }
                        is NetworkResult.Success -> _uiState.update {
                            it.copy(
                                users = result.data ?: emptyList(), isLoading = false
                            )
                        }
                    }
                }
            //                  if (!Utils.hasInternetConnection(appContext))
            //                      _uiError.send("no hay internet"+ BuildConfig.API_KEY)
            //                     // _uiState.value = UiState.Failure("no hay internet")
            //                  else
            //                      _uiError.send("hay internet")
            //                      //_uiState.value = UiState.Failure("hay internet")
        }
    }
}