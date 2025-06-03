package com.mobilemaker.movienow.util

import com.mobilemaker.movienow.models.Movie

object MovieUtil {

    fun mockMovie(): Movie {
        return Movie(
            id = "1",
            title = "Inception",
            description = "A thief who steals corporate secrets through dream-sharing technology.",
            releaseYear = 2010,
            durationMinutes = 148,
            rating = 8.8,
            posterUrl = "https://i.ytimg.com/vi/YoHD9XEInc0/hq720.jpg",
            trailerUrl = "https://www.youtube.com/embed/YoHD9XEInc0"
        )
    }

    fun mockListMovies(): List<Movie> {
        return listOf(
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
                title = "Bohemian Rhapsody",
                description = "A chronicle of Freddie Mercury's life and Queen's rise to fame.",
                releaseYear = 2018,
                durationMinutes = 134,
                rating = 7.9,
                posterUrl = "https://i.ytimg.com/vi/mP0VHJYFOAU/hq720.jpg",
                trailerUrl = "https://www.youtube.com/embed/mP0VHJYFOAU"
            ),
            Movie(
                id = "3",
                title = "School of Rock",
                description = "A struggling musician becomes a substitute teacher and turns his class into a rock band.",
                releaseYear = 2003,
                durationMinutes = 108,
                rating = 7.2,
                posterUrl = "https://i.ytimg.com/vi/3PsUJFEBC74/hq720.jpg",
                trailerUrl = "https://www.youtube.com/embed/3PsUJFEBC74"
            )
        )
    }
}