package com.example.movieapp.data.usecase

import com.example.movieapp.data.network.repoImpl.MovieRepositoryImpl
import com.example.movieapp.domain.model.MoviesList
import retrofit2.Response

class GetMovieListUseCase(private val repositoryImpl: MovieRepositoryImpl) {
    operator suspend fun invoke(page:Int): Response<MoviesList> = repositoryImpl.getMovieList(page)
}