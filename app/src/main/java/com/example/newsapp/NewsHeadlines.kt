package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.models.Article
import com.example.newsapp.models.RequestManager
import com.example.newsapp.models.newsApiResponse
import com.example.newsapp.models.onFetchDataListener

class NewsHeadlines : Fragment() {

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: newsRvAdapter
    private lateinit var listener: onFetchDataListener<newsApiResponse>
    private var listf = ArrayList<Article>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news_headlines, container, false)

        recycler = view.findViewById(R.id.RVNews)
        recycler.setHasFixedSize(true)
        adapter = newsRvAdapter(listf, requireContext())
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())

        listener = object : onFetchDataListener<newsApiResponse> {
            override fun onFetchData(list: List<Article>, message: String) {
                listf.clear() // Clear previous data
                listf.addAll(list) // Add new data
                adapter.notifyDataSetChanged() // Notify adapter of data change
            }

            override fun onError(message: String) {
                // Handle error logic if needed
            }
        }

        // Initialize RequestManager and fetch news headlines
        val manager = RequestManager(requireContext())
        manager.getNewsHeadlines(listener, null,"general")

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize listener to update listf and notify adapter

    }
}