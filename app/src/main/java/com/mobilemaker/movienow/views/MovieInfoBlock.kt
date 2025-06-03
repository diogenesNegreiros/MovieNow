package com.mobilemaker.movienow.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mobilemaker.movienow.R
import com.mobilemaker.movienow.models.Movie
import com.mobilemaker.movienow.ui.theme.MovieAppTheme
import com.mobilemaker.movienow.util.MockUtil

@Composable
fun MovieInfoBlock(movie: Movie) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val imageRequest = ImageRequest.Builder(LocalContext.current)
            .data(movie.posterUrl)
            .crossfade(true)
            .build()

        AsyncImage(
            model = imageRequest,
            contentDescription = movie.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Gray)
        )
        Text(movie.title, style = MaterialTheme.typography.headlineSmall, color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Text(movie.description, style = MaterialTheme.typography.bodySmall, color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.year, movie.releaseYear), color = Color.Gray)
            Text(stringResource(R.string.dura_o_min, movie.durationMinutes), color = Color.Gray)
            Text("⭐ ${movie.rating}/10", color = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieInfoBlockPreview() {
    MovieAppTheme {
        Surface(color = Color.Black) {
            MovieInfoBlock(movie = MockUtil.mockMovie())
        }
    }
}