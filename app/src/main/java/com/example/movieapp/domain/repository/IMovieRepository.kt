package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.Data
import com.example.movieapp.domain.model.Details
import com.example.movieapp.domain.model.MoviesList
import com.example.movieapp.presentation.NetworkResult
import retrofit2.Response

interface IMovieRepository {
    suspend fun getMovieList(page:Int) : NetworkResult<MoviesList>

    suspend fun getMovieDetailId(id:Int): NetworkResult<Details>
}