package com.example.movieapp.presentation.movie_list_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.network.repoImpl.MovieRepositoryImpl
import com.example.movieapp.data.usecase.GetMovieListUseCase
import com.example.movieapp.domain.model.Data
import com.example.movieapp.domain.model.MoviesList
import com.example.movieapp.presentation.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieListResponse : MutableState<MovieListState> = mutableStateOf(MovieListState())
    val movieListResponse : State<MovieListState> = _movieListResponse



    fun  getMovieList(page: Int) = viewModelScope.launch {
        val response = getMovieListUseCase.invoke(page).collect(){movieList->
            when(movieList){
                is NetworkResult.Error -> {
                    _movieListResponse.value = MovieListState(
                        movies = MoviesList(),
                        isError = "Error",
                        isLoading = false,
                        isSucces = false
                    )

                }
                is NetworkResult.Loading -> {
                    _movieListResponse.value = MovieListState(
                        movies = MoviesList(),
                        isSucces = false,
                        isLoading = true,
                        isError = ""
                    )
                }
                is NetworkResult.Succes -> {
                    _movieListResponse.value = MovieListState(
                        movies = movieList.data,
                        isLoading = false,
                        isError = "",
                        isSucces = true
                    )
                }
            }
        }
    }
}

data class MovieListState(
    val movies: MoviesList = MoviesList(),
   // val page: Int = 1,
    val isError  :String ="",
    val isLoading : Boolean = false,
    val isSucces : Boolean = false

)