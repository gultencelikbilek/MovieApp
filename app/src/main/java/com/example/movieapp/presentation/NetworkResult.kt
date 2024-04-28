package com.example.movieapp.presentation

sealed class NetworkResult<out T> {
    data class Succes<T>(val data :T):NetworkResult<T>()
    data class Error<T>(val message : String): NetworkResult<T>()
    data class Loading<T>(var isLoading : Boolean= false) : NetworkResult<T>()
}