package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.home_screen.HomeScreen
import com.example.movieapp.presentation.movie_list_screen.MovieListScreen

@Composable
fun NavigationUI() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination ="home_screen" ){
        composable("home_screen"){
            HomeScreen(navController)
        }
        composable("movie_list_screen"){
            MovieListScreen(navController)
        }
    }
}