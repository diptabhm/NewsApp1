package com.example.newsapp

data class NewsModal(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)