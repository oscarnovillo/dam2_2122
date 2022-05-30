package com.example.pruebasimple.ui.screens.detail

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.pruebasimple.ui.screens.shared.ArrowBackIcon
import com.example.pruebasimple.model.getMedia

import com.example.pruebasimple.ui.screens.shared.Thumb


@Composable
fun DetailScreen(mediaId: Int, onUpClick: () -> Unit) {
    val mediaItem = remember { getMedia().first { it.id == mediaId } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = mediaItem.title) },
                navigationIcon = { ArrowBackIcon(onUpClick) }
            )
        }
    ) {
        Thumb(mediaItem = mediaItem)
    }
}