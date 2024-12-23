package com.example.data.remote

import com.example.domain.dto.NewsResponse
import com.example.domain.dto.SourceResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("everything")
    suspend fun getNews(
        @Query("apiKey") apiKey: String,
        @Query("q") source: String,
        @Query("sources") sources: String
    ): NewsResponse

    @GET("top-headlines/sources")
    suspend fun getSources(
        @Query("apiKey") apiKey: String
    ): SourceResponse
}