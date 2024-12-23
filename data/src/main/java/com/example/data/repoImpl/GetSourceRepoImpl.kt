package com.example.data.repoImpl

import com.example.data.remote.ApiService
import com.example.domain.dto.SourceResponse
import com.example.domain.repo.GetSourceRepo

class GetSourceRepoImpl(private val apiService: ApiService) : GetSourceRepo {
    override suspend fun getSources(): SourceResponse {
        return apiService.getSources("6a236058a40d472fb5a7404b61c7ca93")
    }
}