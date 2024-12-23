package com.example.newsapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.R
import com.example.newsapp.navigation.Screen
import com.example.newsapp.ui.components.LeftHomeCard
import com.example.newsapp.ui.components.NewsAppBar
import com.example.newsapp.ui.components.RightHomeCard
import com.example.newsapp.viewmodels.NewsViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {
    // Drawer state (initialized to DrawerValue.Closed)
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val systemUiController = rememberSystemUiController()

    // Set the status bar color
    systemUiController.setStatusBarColor(
        color = colorResource(id = R.color.green),
        darkIcons = false
    )

    // Drawer layout with the main content
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Apply transparent background to the drawer's content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent) // Make the drawer content background transparent
            ) {
                DrawerContent(
                    onItemClick = { item ->
                        scope.launch { drawerState.close() } // Close the drawer after selecting an item
                        when (item) {
                            "Categories" -> { /* Handle Categories navigation */
                            }

                            "Settings" -> { /* Handle Settings navigation */
                            }
                        }
                    }
                )
            }
        },
        content = {
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
                    // Top App Bar

                    Spacer(modifier = Modifier.height(16.dp))

                    // Page Content
                    Text(
                        modifier = Modifier
                            .padding(start = 32.dp, bottom = 32.dp)
                            .align(Alignment.Start),
                        text = "Pick your category \n" +
                                "of interest",
                        fontFamily = FontFamily(
                            Font(R.font.poppinssemibold, FontWeight.Bold)
                        ),
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = colorResource(id = R.color.lightGray)
                    )

                    // First Row of Categories
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LeftHomeCard(R.color.red, R.drawable.ball, "Sports", "sports", onClick = {
                            navController.navigate(
                                Screen.NewsScreen.createRoute(
                                    "Sports",
                                    "sports"
                                )
                            )
                        })
                        Spacer(modifier = Modifier.width(24.dp))
                        RightHomeCard(
                            R.color.blue,
                            R.drawable.politics,
                            "Politics",
                            "politics",
                            onClick = { Screen.NewsScreen.createRoute("Politics", "politics") })
                    }

                    // Second Row of Categories
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LeftHomeCard(R.color.pink, R.drawable.heart, "Health", "health", onClick = {
                            navController.navigate(
                                Screen.NewsScreen.createRoute(
                                    "Health",
                                    "health"
                                )
                            )
                        })
                        Spacer(modifier = Modifier.width(24.dp))
                        RightHomeCard(
                            R.color.brown,
                            R.drawable.business,
                            "Business",
                            "business",
                            onClick = {
                                navController.navigate(
                                    Screen.NewsScreen.createRoute(
                                        "Business",
                                        "business"
                                    )
                                )
                            })
                    }

                    // Third Row of Categories
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LeftHomeCard(
                            R.color.baby_blue,
                            R.drawable.earth,
                            "Environment",
                            "general",
                            onClick = {
                                navController.navigate(
                                    Screen.NewsScreen.createRoute(
                                        "Environment",
                                        "general"
                                    )
                                )
                            })
                        Spacer(modifier = Modifier.width(24.dp))
                        RightHomeCard(R.color.yellow, R.drawable.science, "Science", "science",
                            onClick = {
                                navController.navigate(
                                    Screen.NewsScreen.createRoute(
                                        "Science",
                                        "science"
                                    )
                                )
                            })
                    }
                }
            }
        }
    )
}


@Composable
fun DrawerContent(onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.75f)
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Menu",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Categories Menu Item
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick("Categories") } // Pass "Categories" to onItemClick
                .padding(vertical = 12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.menu__1_),
                contentDescription = "Categories",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Categories", fontSize = 18.sp, color = Color.Black)
        }

        // Settings Menu Item
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick("Settings") } // Pass "Settings" to onItemClick
                .padding(vertical = 12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.setting),
                contentDescription = "Settings",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Settings", fontSize = 18.sp, color = Color.Black)
        }
    }
}

