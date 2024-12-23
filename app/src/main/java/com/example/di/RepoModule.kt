package com.example.di

import com.example.data.remote.ApiService
import com.example.data.repoImpl.GetNewsRepoImpl
import com.example.data.repoImpl.GetSourceRepoImpl
import com.example.domain.repo.GetNewsRepo
import com.example.domain.repo.GetSourceRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideGetNewsRepo(apiService: ApiService): GetNewsRepo {
        return GetNewsRepoImpl(apiService)
    }

    @Provides
    fun provideGetSourceRepo(apiService: ApiService): GetSourceRepo {
        return GetSourceRepoImpl(apiService)
    }


}