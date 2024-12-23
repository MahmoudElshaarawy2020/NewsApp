package com.example.newsapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapp.ui.components.NewsAppBar
import com.example.newsapp.ui.screens.details.DetailsScreen
import com.example.newsapp.ui.screens.home.HomeScreen
import com.example.newsapp.ui.screens.news.NewsScreen

@Composable
fun AppNavigation(drawerState : DrawerState) {
    val navController = rememberNavController()

    Scaffold(topBar = {
        NewsAppBar(drawerState = drawerState)
    }) { paddingValues ->
        NavHost(navController = navController, startDestination = Screen.Home.route,
            modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(
                route = Screen.NewsScreen.route,
                arguments = listOf(
                    navArgument("title") { type = NavType.StringType },
                    navArgument("id") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val title = backStackEntry.arguments?.getString("title") ?: "News App"
                val id = backStackEntry.arguments?.getString("id") ?: ""
                NewsScreen(navController = navController, title = title, id = id)
            }
            composable(
                route = Screen.DetailsScreen.route,
                arguments = listOf(navArgument("title") { type = NavType.StringType })
            ) { backStackEntry ->
                val title = backStackEntry.arguments?.getString("title")
                DetailsScreen(navController = navController, title = title)
            }

        }
    }
}