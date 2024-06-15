package com.example.newsapp.models

data class newsApiResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
