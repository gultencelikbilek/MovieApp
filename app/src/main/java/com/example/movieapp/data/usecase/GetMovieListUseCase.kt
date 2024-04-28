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
    operator suspend fun invoke(page:Int): Flow<NetworkResult<MoviesList>> = flow {

        try {
            emit(NetworkResult.Loading(true))
            emit(repositoryImpl.getMovieList(page))
            Log.d("repoimpl:",repositoryImpl.getMovieList(page).toString())
        }catch (e:Exception){
           emit(NetworkResult.Error(e.message.toString()))
        }
    }
}