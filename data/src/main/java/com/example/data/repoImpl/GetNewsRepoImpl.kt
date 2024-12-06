package com.example.data.repoImpl

import com.example.data.remote.ApiService
import com.example.domain.dto.NewsResponse
import com.example.domain.repo.GetNewsRepo

class GetNewsRepoImpl(private val apiService: ApiService) : GetNewsRepo {
    override suspend fun getNews(source : String): NewsResponse {
        return apiService.getNews("6a236058a40d472fb5a7404b61c7ca93", source)
    }

}