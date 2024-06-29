package com.example.movieapp.presentation.movie_list_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.usecase.GetMovieListUseCase
import com.example.movieapp.domain.model.Data
import com.example.movieapp.presentation.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieListState = mutableStateOf(MovieState())
    val movieListState: State<MovieState> = _movieListState

    init {
        movieList(1)
    }

    fun movieList(page: Int) {
        viewModelScope.launch {
            getMovieListUseCase(page).collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _movieListState.value = MovieState(data = result)
                        Log.d("MovieListViewModel", "Movie list retrieved successfully")
                    }
                    is NetworkResult.Error -> {
                        _movieListState.value = MovieState(isError = result.message)
                        Log.e("MovieListViewModel", "Error retrieving movie list: ${result.message}")
                    }
                    NetworkResult.Loading -> {
                        _movieListState.value = MovieState(isLoading = true)
                    }
                }
            }
        }
    }
}


data class MovieState(
    val data : NetworkResult<List<Data>>? = null,
    val isError : String? = null,
    val isLoading : Boolean? = false
)