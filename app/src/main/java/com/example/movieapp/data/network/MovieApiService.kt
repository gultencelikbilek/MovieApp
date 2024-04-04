package com.example.movieapp.data.network

import com.example.movieapp.domain.model.MoviesList
import com.example.movieapp.domain.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET(Constants.END_POINT)
    suspend fun getMovieList(
        @Query("page")page : Int
    ):Response<MoviesList>
}