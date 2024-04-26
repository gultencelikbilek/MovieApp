package com.example.movieapp.data.usecase

import com.example.movieapp.data.network.repoImpl.MovieRepositoryImpl
import com.example.movieapp.domain.model.Details
import retrofit2.Response
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repositoryImpl: MovieRepositoryImpl) {
    suspend operator fun invoke(movie_id : Int) : Response<Details> = repositoryImpl.getDetailsMovie(movie_id)
}