package com.example.movieapp.data.network.repoImpl


import com.example.movieapp.data.di.AppModule
import com.example.movieapp.domain.model.Data
import com.example.movieapp.domain.model.Details
import com.example.movieapp.domain.model.MoviesList
import com.example.movieapp.domain.repository.IMovieRepository
import com.example.movieapp.presentation.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(): IMovieRepository {
    override suspend fun getMovieList(page: Int): NetworkResult<MoviesList> {
        return AppModule.api.getMovieList(page)
    }

    override suspend fun getMovieDetailId(id: Int): NetworkResult<Details> {
       return AppModule.api.getMovieDetailId(id)
    }


}