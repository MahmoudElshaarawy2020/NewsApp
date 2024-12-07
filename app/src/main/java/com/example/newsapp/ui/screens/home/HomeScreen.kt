package com.example.newsapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.newsapp.R
import com.example.newsapp.ui.components.LeftHomeCard
import com.example.newsapp.ui.components.NewsAppBar
import com.example.newsapp.ui.components.RightHomeCard
import com.example.newsapp.viewmodels.NewsViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    val systemUiController = rememberSystemUiController()

    // Change the status bar color
    systemUiController.setStatusBarColor(
        color = colorResource(id = R.color.green),
        darkIcons = false
    )
    val customFontFamily = FontFamily(
        Font(R.font.poppinssemibold, FontWeight.ExtraBold),
    )

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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)) // Rounded corners
            ) {
                NewsAppBar(sideMenuIcon = false, title = "News App")
            }

            // Padding between TopAppBar and content
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier
                    .padding(start = 32.dp, bottom = 32.dp)
                    .align(Alignment.Start),
                text = "Pick your category \n" +
                        "of interest",
                fontFamily = customFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = colorResource(id = R.color.lightGray)
            )

            // First Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LeftHomeCard(R.color.red, R.drawable.ball, "Sports", navController)
                Spacer(modifier = Modifier.width(24.dp))
                RightHomeCard(R.color.blue, R.drawable.politics, "Politics", navController)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Second Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LeftHomeCard(R.color.pink, R.drawable.heart, "Health", navController)
                Spacer(modifier = Modifier.width(24.dp))
                RightHomeCard(R.color.brown, R.drawable.business, "Business", navController)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Third Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LeftHomeCard(R.color.baby_blue, R.drawable.earth, "Environment", navController)
                Spacer(modifier = Modifier.width(24.dp))
                RightHomeCard(R.color.yellow, R.drawable.science, "Science", navController)
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

