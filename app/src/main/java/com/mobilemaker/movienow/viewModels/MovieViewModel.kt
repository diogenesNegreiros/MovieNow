package com.mobilemaker.movienow.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilemaker.movienow.models.Movie
import com.mobilemaker.movienow.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    private val _selectedMovie = MutableStateFlow<Movie?>(null)
    val selectedMovie: StateFlow<Movie?> = _selectedMovie

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        fetchMovies()
    }

    fun fetchMovies() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val result = repository.fetchMovies()
                _movies.value = result
            } catch (e: Exception) {
                _errorMessage.value =
                    "Erro ao carregar filmes: ${e.localizedMessage ?: "desconhecido"}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun selectMovie(movie: Movie) {
        _selectedMovie.value = movie
    }

    fun clearSelection() {
        _selectedMovie.value = null
    }

    fun clearError() {
        _errorMessage.value = null
    }
}