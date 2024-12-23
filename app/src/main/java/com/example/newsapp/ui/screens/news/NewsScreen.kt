package com.example.newsapp.ui.screens.news

import NewsCard
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.domain.dto.ArticlesItem
import com.example.newsapp.constants.API_KEY
import com.example.newsapp.navigation.Screen
import com.example.newsapp.ui.components.CategoryLazyRow
import com.example.newsapp.ui.components.NewsAppBar
import com.example.newsapp.viewmodels.GetSourceViewModel
import com.example.newsapp.viewmodels.NewsViewModel
import kotlinx.coroutines.launch

@Composable
fun NewsScreen(
    navController: NavController,
    viewModel: NewsViewModel = hiltViewModel(),
    sourceViewModel: GetSourceViewModel = hiltViewModel(),
    title: String,
    id: String
) {

    val news = viewModel.news.collectAsState()
    val sources = sourceViewModel.sources.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    // Fetch initial data
    LaunchedEffect(key1 = Unit) {
        sourceViewModel.getSources()
        viewModel.getNews(id, sources.value?.sources?.get(0)?.id.orEmpty())
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(16.dp))

        // Dynamic source selection
        CategoryLazyRow(
            listOfSources = sources.value?.sources.orEmpty()
        ) { sourceId ->
            coroutineScope.launch {
                viewModel.getNews(id, sourceId)
            }
        }

        NewsLazyColumn(
            list = news.value?.articles.orEmpty(),
            navController = navController
        )
    }
}



@Composable
fun NewsLazyColumn(navController: NavController, list : List<ArticlesItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(list.size) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                NewsCard(
                    url = list[index].urlToImage ?: "",
                    title = list[index].title ?: "",
                    date = list[index].publishedAt ?: "",
                    onClick = {
                        val title = list[index].title ?: "No Title"
                        navController.navigate(Screen.DetailsScreen.passTitle(title))
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

}

