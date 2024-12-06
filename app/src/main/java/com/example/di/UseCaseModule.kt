package com.example.di

import com.example.domain.repo.GetNewsRepo
import com.example.domain.usecase.GetNews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetNewsUseCase(getNewsRepo: GetNewsRepo): GetNews {
        return GetNews(getNewsRepo)
    }

}