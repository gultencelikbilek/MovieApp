package com.example.movieapp.data.network.repoImpl


import android.util.Log
import com.example.movieapp.data.di.AppModule
import com.example.movieapp.data.network.MovieApiService
import com.example.movieapp.domain.model.Data
import com.example.movieapp.domain.model.Details
import com.example.movieapp.domain.repository.IMovieRepository
import com.example.movieapp.presentation.NetworkResult
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val apiService: MovieApiService) : IMovieRepository {

    override suspend fun getMovieList(page: Int): NetworkResult<List<Data>> {
        return apiService.getMovieList(page)
    }

    override suspend fun getMovieDetailId(id: Int): NetworkResult<Details> {
        return apiService.getMovieDetailId(id)
    }
}
