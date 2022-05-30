package com.example.pruebasimple.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.pruebasimple.ui.theme.PruebaSimpleTheme


@Composable
fun PruebaSimpleApp(content: @Composable () -> Unit) {
    PruebaSimpleTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}