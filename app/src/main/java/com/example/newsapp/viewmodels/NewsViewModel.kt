package com.example.newsapp.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.dto.NewsResponse
import com.example.domain.usecase.GetNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsUseCase: GetNews) : ViewModel() {
    private val _news : MutableStateFlow<NewsResponse?> = MutableStateFlow(null)
    val news : StateFlow<NewsResponse?> = _news

    suspend fun getNews(source: String) {
        try {
            _news.value = getNewsUseCase(source)
            Log.e("NewsViewModel", news.value.toString())
        } catch(e: Exception)
        {
            Log.e("NewsViewModel", "Error fetching news", e)
        }

    }

}