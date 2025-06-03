package com.mobilemaker.movienow.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun MovieCard(movie: Movie, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        val imageRequest = ImageRequest.Builder(LocalContext.current)
            .data(movie.posterUrl)
            .crossfade(true)
            .build()

        AsyncImage(
            model = imageRequest,
            contentDescription = null,
            modifier = Modifier
                .width(180.dp)
                .height(100.dp)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(movie.title, style = MaterialTheme.typography.headlineSmall, color = Color.White)
            Text(
                stringResource(R.string.year_min, movie.releaseYear, movie.durationMinutes),
                color = Color.White
            )
            Text("⭐ ${movie.rating}/10", color = Color.White)
        }
    }
}

//auxílio de IA para melhorar o preview
@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    MovieAppTheme {
        Surface(color = Color.Black) {
            Box(modifier = Modifier.background(Color.Black)) {
                MovieCard(movie = MockUtil.mockMovie(), onClick = {})
            }
        }
    }
}