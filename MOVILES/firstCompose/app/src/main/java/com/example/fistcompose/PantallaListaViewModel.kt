package com.example.fistcompose

import androidx.lifecycle.ViewModel
import com.example.fistcompose.data.ListaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PantallaListaViewModel  @Inject constructor(
    private val repository: ListaRepository
): ViewModel() {

    val listado = repository.getData()

}