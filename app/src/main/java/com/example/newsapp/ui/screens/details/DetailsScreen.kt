package com.example.newsapp.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.newsapp.R
import com.example.newsapp.ui.components.NewsAppBar
import kotlinx.coroutines.launch

@Composable
fun DetailsScreen(
    navController: NavHostController, title : String?
) {
    // Main Screen Content
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.splash_background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(Color.LightGray),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            //just for testing we will remove it later
            Text(
                text = "Details for: ${title?.split(" ")?.take(2)?.joinToString(" ") ?: "No Title"}",
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )

        }
    }
}