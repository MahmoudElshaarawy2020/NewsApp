package com.example.domain.repo

import com.example.domain.dto.NewsResponse

interface GetNewsRepo {
    suspend fun getNews(source: String): NewsResponse
}