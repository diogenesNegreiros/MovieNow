package com.mobilemaker.movienow.repository

import android.content.Context
import com.mobilemaker.movienow.models.Movie
import kotlinx.coroutines.delay
import org.json.JSONObject

interface MovieRepository {
    suspend fun fetchMovies(): List<Movie>
}

class AssetMovieRepository(private val context: Context) : MovieRepository {

    override suspend fun fetchMovies(): List<Movie> {
        delay(2000 )
        val jsonStr = context.assets.open("filmes.json").bufferedReader().use { it.readText() }
        val jsonArray = JSONObject(jsonStr).getJSONObject("data").getJSONArray("movies")
        return (0 until jsonArray.length()).map { i ->
            val obj = jsonArray.getJSONObject(i)
            Movie(
                id = obj.getString("id"),
                title = obj.getString("title"),
                description = obj.getString("description"),
                releaseYear = obj.getInt("releaseYear"),
                durationMinutes = obj.getInt("durationMinutes"),
                rating = obj.getDouble("rating"),
                posterUrl = obj.getString("posterUrl"),
                trailerUrl = obj.getString("trailerUrl")
            )
        }
    }

}