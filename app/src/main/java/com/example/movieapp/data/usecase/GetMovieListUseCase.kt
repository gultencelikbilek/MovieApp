package com.example.movieapp.data.usecase

import android.util.Log
import com.example.movieapp.data.network.repoImpl.MovieRepositoryImpl
import com.example.movieapp.domain.model.Data
import com.example.movieapp.domain.model.MoviesList
import com.example.movieapp.presentation.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(private val repositoryImpl: MovieRepositoryImpl) {

    suspend operator fun invoke(page: Int): Flow<NetworkResult<List<Data>>> = flow {
        try {
            emit(NetworkResult.Loading)
            val movieList = repositoryImpl.getMovieList(page)
            emit(movieList)
            Log.d("GetMovieListUseCase", "Movie list retrieved successfully")
        } catch (e: Exception) {
            emit(NetworkResult.Error(e.message ?: "Unknown error"))
            Log.e("GetMovieListUseCase", "Error retrieving movie list", e)
        }
    }
}

