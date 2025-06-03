package com.mobilemaker.movienow

import com.mobilemaker.movienow.models.Movie
import com.mobilemaker.movienow.repository.MovieRepository
import com.mobilemaker.movienow.viewModels.MovieViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

//IA para auxiliar nos testes

@OptIn(ExperimentalCoroutinesApi::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)

        // ✅ FakeMovieRepository inline usando interface
        val fakeRepository = object : MovieRepository {
            override suspend fun fetchMovies(): List<Movie> {
                return listOf(
                    Movie(
                        id = "1",
                        title = "Inception",
                        description = "A mind-bending thriller.",
                        releaseYear = 2010,
                        durationMinutes = 148,
                        rating = 8.8,
                        posterUrl = "",
                        trailerUrl = ""
                    )
                )
            }
        }

        viewModel = MovieViewModel(fakeRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchMovies loads movies and sets loading state`() = runTest {
        viewModel.fetchMovies()
        advanceUntilIdle()

        val movies = viewModel.movies.first()
        val isLoading = viewModel.isLoading.first()

        Assert.assertEquals(1, movies.size)
        Assert.assertEquals("Inception", movies[0].title)
        Assert.assertFalse(isLoading)
    }

    @Test
    fun `selectMovie sets selectedMovie`() = runTest {
        val movie = Movie("2", "Matrix", "Simulação", 1999, 136, 8.7, "", "")
        viewModel.selectMovie(movie)

        val selected = viewModel.selectedMovie.first()
        Assert.assertEquals(movie, selected)
    }

    @Test
    fun `clearSelection sets selectedMovie to null`() = runTest {
        viewModel.clearSelection()
        val selected = viewModel.selectedMovie.first()
        Assert.assertNull(selected)
    }
}