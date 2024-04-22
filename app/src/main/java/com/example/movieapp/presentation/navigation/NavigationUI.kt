package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.presentation.home_screen.HomeScreen
import com.example.movieapp.presentation.movie_details_screen.MovieDetailScreen
import com.example.movieapp.presentation.movie_list_screen.MovieListScreen

@Composable
fun NavigationUI() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination ="home_screen" ){
        composable("home_screen"){
            HomeScreen(navController)
        }
        composable("movie_list_screen"){
            MovieListScreen(navController = navController)
        }
        composable("movie_detail_screen/{movie_id}",
            arguments = listOf(
                navArgument(
                    name = "movie_id"
                ){
                    type = NavType.IntType
                }
            )
        ){id ->
            id.arguments?.getInt("movie_id")?.let { id1->
                MovieDetailScreen(id = id1)
            }
        }
    }
}