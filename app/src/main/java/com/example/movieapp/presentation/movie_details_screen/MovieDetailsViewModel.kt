package com.example.movieapp.presentation.movie_details_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.usecase.GetMovieDetailsUseCase
import com.example.movieapp.domain.model.Data
import com.example.movieapp.domain.model.Details
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) :ViewModel(){

    var state by mutableStateOf(ScreenState())
    fun getDetailId(movie_id:Int){
        viewModelScope.launch {
            try {
                val response = getMovieDetailsUseCase.invoke(movie_id)
                if (response.isSuccessful){
                    state = state.copy(
                        detailsData = response.body()!!
                    )
                }
            } catch (e:Exception){
                Log.d("MovieDetailViewModel:",e.message.toString())
            }
        }

    }
}

data class ScreenState(
    val movies: List<Data> = emptyList(),
    val page: Int = 1,
    val detailsData : Details = Details()
)