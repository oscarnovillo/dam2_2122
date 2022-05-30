package com.example.pruebasimple.framework.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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


@Composable
fun MediaList(
    onClick: (MediaItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(getMedia()) {
            MediaListItem(
                mediaItem = it,
                onClick = { onClick(it) },
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_xsmall))
            )
        }
    }
}


@Composable
fun MediaListItem(
    mediaItem: MediaItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable { onClick() }
    ) {
        Column {
            Thumb(mediaItem)
            Title(mediaItem)
        }
    }
}

@Composable
private fun Title(mediaItem: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.h6
        )
    }
}


@Preview
@Composable
fun MediaListItemPreview() {
    PruebaSimpleApp {


        val mediaItem = MediaItem(1, "Item 1", "", MediaItem.Type.VIDEO)
        MediaListItem(mediaItem = mediaItem, onClick = {})
    }
}