package com.mobilemaker.movienow

import com.mobilemaker.movienow.viewModels.MovieViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mobilemaker.movienow.ui.theme.MovieAppTheme
import com.mobilemaker.movienow.views.MovieApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieAppTheme {
                val viewModel: MovieViewModel = viewModel()
                MovieApp(viewModel)
            }
        }

    }
}

