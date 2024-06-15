package com.example.newsapp.models

import com.example.newsapp.NewsHeadlines

interface onFetchDataListener<newsApiResponse> {
    fun onFetchData(list: List<Article>, message: String)
    fun onError(message: String)
}