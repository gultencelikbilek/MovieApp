package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.MoviesList
import retrofit2.Response

interface IMovieRepository {
    suspend fun getMovieList(page:Int) : Response<MoviesList>
}