package com.example.movieapp.domain.model

data class Metadata(
    val current_page: String,
    val page_count: Int,
    val per_page: Int,
    val total_count: Int
)