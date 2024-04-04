package com.example.movieapp.data.network.repoImpl

import com.example.movieapp.data.network.MovieApiService
import com.example.movieapp.domain.model.MoviesList
import com.example.movieapp.domain.repository.IMovieRepository
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieApiService: MovieApiService): IMovieRepository {
    override suspend fun getMovieList(page: Int): Response<MoviesList> {
        return movieApiService.getMovieList(page)
    }
}