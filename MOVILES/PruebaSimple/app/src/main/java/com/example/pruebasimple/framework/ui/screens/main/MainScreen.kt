package com.example.pruebasimple.framework.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pruebasimple.framework.ui.PruebaSimpleApp
import com.antonioleiva.mymovies.ui.screens.main.MainAppBar


@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onNavigate: (Int) -> Unit,) {

    val state = viewModel.uiState.collectAsState()

    PruebaSimpleApp {
        Scaffold(
            topBar = { MainAppBar() }
        ) { padding ->
            MediaList(
                lista = state.value.users,
                onClick = { onNavigate(it.id) },
                modifier = Modifier.padding(padding)
            )
        }

    }
}