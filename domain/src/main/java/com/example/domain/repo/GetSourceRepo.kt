package com.example.domain.repo

import com.example.domain.dto.SourceResponse

interface GetSourceRepo {
    suspend fun getSources(): SourceResponse
}