package com.example.pruebasimple.framework.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pruebasimple.framework.ui.PruebaSimpleApp
import com.antonioleiva.mymovies.ui.screens.main.MainAppBar


@Composable
fun MainScreen(onNavigate: (Int) -> Unit) {
    PruebaSimpleApp {
        Scaffold(
            topBar = { MainAppBar() }
        ) { padding ->
            MediaList(
                onClick = { onNavigate(it.id) },
                modifier = Modifier.padding(padding)
            )
        }

    }
}