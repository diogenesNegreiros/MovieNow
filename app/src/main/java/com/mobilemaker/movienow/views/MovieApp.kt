package com.mobilemaker.movienow.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mobilemaker.movienow.R
import com.mobilemaker.movienow.viewModels.MovieViewModel

@Composable
fun MovieApp(viewModel: MovieViewModel) {
    val movies by viewModel.movies.collectAsState()
    val selectedMovie by viewModel.selectedMovie.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.errorMessage.collectAsState()

    when {
        isLoading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Text(stringResource(R.string.loading_movies), color = Color.White)
            }
        }

        error != null -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(error ?: "", color = Color.Red)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        viewModel.clearError()
                        viewModel.fetchMovies()
                    }) {
                        Text(stringResource(R.string.default_error_msg))
                    }
                }
            }
        }

        selectedMovie == null -> {
            MovieListScreen(
                movies = movies,
                onMovieClick = { viewModel.selectMovie(it) }
            )
        }

        else -> {
            MovieDetailScreen(
                movie = selectedMovie!!,
                onBack = { viewModel.clearSelection() }
            )
        }
    }
}