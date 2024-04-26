package com.example.movieapp.presentation.movie_list_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.network.repoImpl.MovieRepositoryImpl
import com.example.movieapp.data.usecase.GetMovieListUseCase
import com.example.movieapp.domain.model.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    var state by mutableStateOf(ScreenState())

    init {
        viewModelScope.launch {
            val response =  getMovieListUseCase(state.page)
            state = state.copy(
                movies = response.body()!!.data
            )
            Log.d("movies",state.movies.toString())
        }
    }

}

data class ScreenState(
    val movies: List<Data> = emptyList(),
    val page: Int = 1
)