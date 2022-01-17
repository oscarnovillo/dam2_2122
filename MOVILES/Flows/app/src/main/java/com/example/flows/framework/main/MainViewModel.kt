package com.example.flows.framework.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flows.framework.utils.UiState
import com.example.flows.framework.utils.Utils
import com.example.flows.framework.utils.successData
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(@ApplicationContext val appContext: Context) : ViewModel() {



    private val _uiState: MutableStateFlow<UiState<MainContract.State>> by lazy {
        MutableStateFlow(UiState.Loading)
    }
    val uiState: StateFlow<UiState<MainContract.State>> = _uiState

    private val _uiError =  Channel<String>()
    val uiError = _uiError.receiveAsFlow()


    fun handleEvent(event : MainContract.Event){
      when (event)
      {
          MainContract.Event.PedirDatos -> {

              _uiState.value = UiState.Loading
              viewModelScope.launch {
                  delay(1000)
                  if (!Utils.hasInternetConnection(appContext))
                      _uiError.send("no hay internet")
                     // _uiState.value = UiState.Failure("no hay internet")
                  else
                      _uiError.send("hay internet")
                      //_uiState.value = UiState.Failure("hay internet")
              }
          }
          MainContract.Event.MensajeMostrado -> TODO()
      }


    }




}