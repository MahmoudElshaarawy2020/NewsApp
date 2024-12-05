package com.example.data.remote

import com.example.domain.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("everything")
    suspend fun getNews(
        @Query("apiKey") apiKey: String,
        @Query("q") source: String
    ): NewsResponse
}