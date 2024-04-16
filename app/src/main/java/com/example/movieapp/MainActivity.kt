package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.presentation.home_screen.HomeScreen
import com.example.movieapp.presentation.movie_list_screen.MovieListScreen
import com.example.movieapp.presentation.movie_list_screen.MovieListViewModel
import com.example.movieapp.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewmodel : MovieListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                Color(0xFFB226E1),
                                Color(0xFFFC6603),
                                Color(0xFF5995EE),
                                Color(0xFF3D3535)
                            )
                        )
                    )){
                    MovieListScreen()
                }

             //   Surface(
             //       modifier = Modifier.fillMaxSize(),
             //       color = MaterialTheme.colorScheme.background
             //   ) {
             //       Text(text = "${viewmodel.state.movies}")
             //   }
            }
        }
    }
}
