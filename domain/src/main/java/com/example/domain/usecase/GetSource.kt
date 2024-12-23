package com.example.domain.usecase

import com.example.domain.repo.GetSourceRepo

class GetSource(private val getSourceRepo: GetSourceRepo) {
    suspend operator fun invoke() = getSourceRepo.getSources()
}