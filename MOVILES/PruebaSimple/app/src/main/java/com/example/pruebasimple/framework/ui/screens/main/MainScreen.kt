package com.example.pruebasimple.framework.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.antonioleiva.mymovies.ui.screens.main.MainAppBar
import com.example.pruebasimple.framework.ui.PruebaSimpleApp
import com.example.pruebasimple.framework.ui.screens.main.MainContract.Event.MensajeMostrado
import com.example.pruebasimple.framework.ui.screens.main.MainContract.Event.PedirDatos
import kotlinx.coroutines.flow.collect


@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onNavigate: (Int) -> Unit,
) {

    val state = viewModel.uiState.collectAsState()
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.error.collect {
            scaffoldState.snackbarHostState.showSnackbar(
                message = "Channel $it"

            )

        }
    }


    LaunchedEffect(key1 = state.value.error) {
        state.value.error?.let { error ->
            scaffoldState.snackbarHostState.showSnackbar(
                message = "state $error"

            )

            viewModel.handleEvent(MensajeMostrado)
        }
    }


    PruebaSimpleApp {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { MainAppBar() }
        ) { padding ->
            Box(
                modifier = Modifier.fillMaxSize()

            ) {
                if (state.value.isLoading)
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                MediaList(
                    lista = state.value.users,
                    onPedirDatos = { viewModel.handleEvent(PedirDatos) },
                    onClick = { onNavigate(it.id) },
                    modifier = Modifier.padding(padding)
                        .align(Alignment.TopStart)
                )
            }
        }

    }
}