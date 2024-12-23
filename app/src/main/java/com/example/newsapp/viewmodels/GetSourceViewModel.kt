package com.example.newsapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.dto.Source
import com.example.domain.dto.SourceResponse
import com.example.domain.usecase.GetSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class GetSourceViewModel @Inject constructor(private val getSourceUseCase: GetSource) :
    ViewModel() {
    private val _sources: MutableStateFlow<SourceResponse?> = MutableStateFlow(null)
    val sources: StateFlow<SourceResponse?> = _sources

    suspend fun getSources() {
        try {
            _sources.value = getSourceUseCase()
        } catch (e: Exception) {
            Log.e("NewsViewModel", "Error fetching news", e)

        }
    }
}