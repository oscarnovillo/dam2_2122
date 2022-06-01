package com.example.pruebasimple.framework.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pruebasimple.framework.ui.screens.shared.Thumb
import com.example.pruebasimple.domain.model.MediaItem
import com.example.pruebasimple.domain.model.getMedia
import com.example.pruebasimple.framework.ui.PruebaSimpleApp
import com.example.pruebasimple.R
import com.example.pruebasimple.domain.model.TipoUsuario


@Composable
fun MediaList(
    lista: List<TipoUsuario>,
    onPedirDatos: () -> Unit,
    onClick: (TipoUsuario) -> Unit,
    modifier: Modifier = Modifier
) {

    Column() {
        Button(onClick = onPedirDatos) {
            Text("pedir Datos")
        }

        LazyColumn(
            modifier = modifier
        ) {
            items(lista) {
                MediaListItem(
                    mediaItem = it,
                    onClick = { onClick(it) },
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_xsmall))
                )
            }
        }
    }
}


@Composable
fun MediaListItem(
    mediaItem: TipoUsuario,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable { onClick() }
    ) {
        Column {
            Title(mediaItem)
        }
    }
}

@Composable
private fun Title(mediaItem: TipoUsuario) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = mediaItem.tipo,
            style = MaterialTheme.typography.h6
        )
    }
}

