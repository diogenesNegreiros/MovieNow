package com.mobilemaker.movienow.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mobilemaker.movienow.models.Movie
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*

@Composable
fun MovieListScreen(
    movies: List<Movie>,
    onMovieClick: (Movie) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Stringhi Filmes") },
                backgroundColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.primary
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(movies) { movie ->
                MovieCard(movie = movie, onClick = { onMovieClick(movie) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieListScreenPreview() {
    val mockMovies = listOf(
        Movie(
            id = "1",
            title = "Inception",
            description = "A thief who steals corporate secrets through dream-sharing technology.",
            releaseYear = 2010,
            durationMinutes = 148,
            rating = 8.8,
            posterUrl = "https://i.ytimg.com/vi/YoHD9XEInc0/hq720.jpg",
            trailerUrl = "https://www.youtube.com/embed/YoHD9XEInc0"
        ),
        Movie(
            id = "2",
            title = "The Matrix",
            description = "A hacker discovers the reality is a simulation.",
            releaseYear = 1999,
            durationMinutes = 136,
            rating = 8.7,
            posterUrl = "https://i.ytimg.com/vi/vKQi3bBA1y8/hq720.jpg",
            trailerUrl = "https://www.youtube.com/embed/vKQi3bBA1y8"
        )
    )

    MovieListScreen(movies = mockMovies, onMovieClick = {})
}