package com.example.newsapp.models

data class Article(
    val author: String = "",
    val content: String = "",
    val description: String = "",
    val publishedAt: String = "",
    val source: source? = null,
    val title: String= "",
    val url: String= "",
    val urlToImage: String= ""
)