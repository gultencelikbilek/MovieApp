package com.example.movieapp.data.network

import com.example.movieapp.domain.model.Data
import com.example.movieapp.domain.model.Details
import com.example.movieapp.domain.model.DetailsList
import com.example.movieapp.domain.model.MoviesList
import com.example.movieapp.domain.util.Constants
import com.example.movieapp.presentation.NetworkResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET(Constants.END_POINT)
    suspend fun getMovieList(
        @Query("page") page: Int
    ): NetworkResult<List<Data>>

    @GET(Constants.END_POINT_ID)
    suspend fun getMovieDetailId(
        @Path("movie_id") id: Int
    ): NetworkResult<Details>
}
