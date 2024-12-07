package com.example.newsapp.ui.screens.news

import NewsCard
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.example.domain.dto.ArticlesItem
import com.example.newsapp.ui.components.NewsAppBar
import com.example.newsapp.viewmodels.NewsViewModel

@Composable
fun NewsScreen(
    navController: NavController,
    viewModel: NewsViewModel = hiltViewModel(),
    title: String
) {
    val news = viewModel.news.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.getNews("bbc-news")
    }

    Column(modifier = Modifier.fillMaxSize()) {
        NewsAppBar(sideMenuIcon = false, title = title)
        NewsLazyColumn(list = news.value?.articles ?: emptyList())
    }

}

@Composable
fun NewsLazyColumn(list : List<ArticlesItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(list.size) {
            NewsCard(
                url = list[it].urlToImage ?: "",
                title = list[it].title ?: "",
                date = list[it].publishedAt ?: ""
            )
        }
    }
}

