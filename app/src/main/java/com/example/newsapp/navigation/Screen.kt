package com.example.newsapp.navigation

import android.net.Uri

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object NewsScreen : Screen("news_screen/{title}/{id}") {
        fun createRoute(title: String, id: String): String {
            return "news_screen/${Uri.encode(title)}/$id"
        }
    }

    object DetailsScreen : Screen("details_screen/{title}") {
        fun passTitle(title: String): String {
            return "details_screen/${title}"
        }

    }
}