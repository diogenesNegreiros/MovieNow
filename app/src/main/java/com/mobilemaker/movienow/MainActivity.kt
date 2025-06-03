package com.mobilemaker.movienow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mobilemaker.movienow.repository.AssetMovieRepository
import com.mobilemaker.movienow.ui.theme.MovieAppTheme
import com.mobilemaker.movienow.viewModels.MovieViewModel
import com.mobilemaker.movienow.viewModels.MovieViewModelFactory
import com.mobilemaker.movienow.views.MovieApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieAppTheme {
                val context = LocalContext.current
                val repository = remember { AssetMovieRepository(context) } // ou outro
                val factory = remember { MovieViewModelFactory(repository) }
                val viewModel: MovieViewModel = viewModel(factory = factory)
                MovieApp(viewModel)
            }
        }

    }
}