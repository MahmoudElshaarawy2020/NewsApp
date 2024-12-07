package com.example.newsapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object NewsScreen : Screen("news_screen/{title}") {
        fun createRoute(title: String) = "news_screen/$title"
    }
}