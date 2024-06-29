package com.example.movieapp.presentation.movie_list_screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.Header
import com.example.movieapp.presentation.MovieCardComponent
import com.example.movieapp.presentation.NetworkResult

@Composable
fun MovieListScreen(
    navHostController: NavHostController,
    movieListViewModel: MovieListViewModel = hiltViewModel()
) {
    val movieState = movieListViewModel.movieListState.value
    val context = LocalContext.current

    LaunchedEffect(key1 = movieState) {
        when (val result = movieState.data) {
            is NetworkResult.Success -> {
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
            }
            is NetworkResult.Error -> {
                Toast.makeText(context, "Error: ${result.message}", Toast.LENGTH_SHORT).show()
                Log.d("eerorscreen", result.message ?: "Unknown error")
            }

            NetworkResult.Loading -> {

                Toast.makeText(context, "Error: ${result}", Toast.LENGTH_SHORT).show()
            }
            null -> {
                Toast.makeText(context, "Error: ${result}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Header()
            if (movieState.data is NetworkResult.Success) {
                LazyColumn {
                    when (val data = movieState.data) {
                        is NetworkResult.Success -> {
                            items(data.data) { movie ->
                                MovieCardComponent(movie)
                            }
                        }
                        is NetworkResult.Error -> {

                        }
                        is NetworkResult.Loading -> {
                            // Handle loading state if needed
                        }

                        null -> {

                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieListScreenPreview() {
    // NavHostController'ın mock bir versiyonunu oluşturun
    val navController = rememberNavController()
    MovieListScreen(navHostController = navController)
}
