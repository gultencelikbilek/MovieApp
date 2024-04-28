package com.example.movieapp.data.usecase

import com.example.movieapp.data.network.repoImpl.MovieRepositoryImpl
import com.example.movieapp.domain.model.Details
import com.example.movieapp.presentation.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repositoryImpl: MovieRepositoryImpl) {

    operator suspend fun invoke(id:Int) : Flow<NetworkResult<Details>>  = flow {
        try {
            emit(NetworkResult.Loading(true ))
            emit(repositoryImpl.getMovieDetailId(id))

        }catch (e:Exception){
            emit(NetworkResult.Error(e.message.toString()))
        }
    }
}