package com.example.domain.usecase

import com.example.domain.dto.NewsResponse
import com.example.domain.repo.GetNewsRepo

class GetNews(private val getNewsRepo: GetNewsRepo) {
    suspend operator fun invoke(source : String) = getNewsRepo.getNews(source)
}