package com.example.movieapp.domain.model

data class MoviesList(
    val `data`: List<Data> = emptyList(),
    val metadata: Metadata = com.example.movieapp.domain.model.Metadata()
)