package com.example.newsapp.models

import android.content.Context
import android.widget.Toast
import com.example.newsapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

public class RequestManager(var context: Context){

    val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getNewsHeadlines(
        listener: onFetchDataListener<newsApiResponse>,
        query: String?,
        category: String){
        val callNewsApi: CallNewsApi = retrofit.create(CallNewsApi::class.java)

        val call: Call<newsApiResponse> = callNewsApi.callHeadlines(
            country = "in",
            category = category,
            query = query,
            apiKey = context.getString(R.string.api_key)
        )

        try {
            call.enqueue(object : Callback<newsApiResponse> {
                override fun onResponse(call: Call<newsApiResponse>, response: Response<newsApiResponse>) {
                    if(!response.isSuccessful()){
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                    }

                    listener.onFetchData(response.body()!!.articles,response.message())
                }

                override fun onFailure(call: Call<newsApiResponse>, t: Throwable) {
                    listener.onError("Request failed")
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    interface CallNewsApi {
        @GET("top-headlines")
        fun callHeadlines(
            @Query("country") country: String,
            @Query("category") category: String,
            @Query("q") query: String?,
            @Query("apiKey") apiKey: String
        ): Call<newsApiResponse>
    }
}