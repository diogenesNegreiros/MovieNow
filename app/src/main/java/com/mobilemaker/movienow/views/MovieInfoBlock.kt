package com.mobilemaker.movienow.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilemaker.movienow.models.Movie

@Composable
fun MovieInfoBlock(movie: Movie) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(movie.title, style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(8.dp))
        Text(movie.description, style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Ano: ${movie.releaseYear}")
        Text("Duração: ${movie.durationMinutes} min")
        Text("⭐ ${movie.rating}/10")
    }
}