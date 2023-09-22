package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class News_details : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var title: String
    private lateinit var description: String
    private lateinit var content: String
    private lateinit var imageUrl: String
    private lateinit var url: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        title = arguments?.getString("title").toString()
        description = arguments?.getString("description").toString()
        content = arguments?.getString("content").toString()
        imageUrl = arguments?.getString("image").toString()
        url = arguments?.getString("url").toString()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_details, container, false)
    }
}