package com.example.movieapp.presentation.movie_list_screen

import com.example.movieapp.presentation.movie_list_screen.MovieListViewModel
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MovieListScreen(
    viewModel: MovieListViewModel = viewModel()
) {
        Text(text = "${viewModel.state.movies}")

}