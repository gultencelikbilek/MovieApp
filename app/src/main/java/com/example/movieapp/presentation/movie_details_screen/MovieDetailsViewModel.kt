package com.example.movieapp.presentation.movie_details_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.usecase.GetMovieDetailsUseCase
import com.example.movieapp.domain.model.Data
import com.example.movieapp.domain.model.Details
import com.example.movieapp.presentation.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {

    private val _movieDetailResponse: MutableState<MovieDetailState> = mutableStateOf(MovieDetailState())
    val movieDetailRepsonse: State<MovieDetailState> = _movieDetailResponse

    fun getMovieDetailId(id:Int) = viewModelScope.launch {
        val response = getMovieDetailsUseCase.invoke(id).collect(){movieDetailResult ->
            when(movieDetailResult){
                is NetworkResult.Error -> {
                    _movieDetailResponse.value = MovieDetailState(
                    detailsData = Details(),
                    isError = "test",
                    isLoading = false,
                    isSucces = false
                    )
                }
                is NetworkResult.Loading ->{
                    _movieDetailResponse.value = MovieDetailState(
                        detailsData = Details(),
                        isError = "",
                        isSucces = false,
                        isLoading = true

                    )
                }
                is NetworkResult.Succes -> {
                    _movieDetailResponse.value = MovieDetailState(
                        detailsData = movieDetailResult.data,
                        isError = "",
                        isSucces = true,
                        isLoading = false
                    )
                }
            }
        }
    }
}


data class MovieDetailState(
    val detailsData: Details = Details(),
    val isError: String = "",
    val isSucces: Boolean = false,
    val isLoading: Boolean = false
)