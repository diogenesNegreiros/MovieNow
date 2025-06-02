package com.mobilemaker.movienow.repository

import android.content.Context
import com.mobilemaker.movienow.models.Movie
import org.json.JSONObject

class MovieRepository(private val context: Context) {

    fun fetchMovies(): List<Movie> {
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