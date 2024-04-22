package com.example.movieapp.domain.model

data class Details(
    val country: String = "",
    val genres: List<String> = emptyList(),
    val id: Int = 0,
    val images: List<String> = emptyList(),
    val imdb_rating: String ="",
    val poster: String ="",
    val title: String = "",
    val year: String =""
)