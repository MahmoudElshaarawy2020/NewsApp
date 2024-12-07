package com.example.newsapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.newsapp.R
import com.example.newsapp.navigation.Screen

@Composable
fun LeftHomeCard(
    color : Int, image : Int, title : String, navController: NavHostController) {
    val customFontFamily = FontFamily(
        Font(R.font.exosemibold, FontWeight.SemiBold),
    )
    Card(
        shape = RoundedCornerShape(
            topStart = 24.dp,  // Rounded top-left corner
            topEnd = 24.dp,    // Rounded top-right corner
            bottomStart = 24.dp, // Rounded bottom-left corner
            bottomEnd = 0.dp    // No rounding for bottom-right corner
        ),
        modifier = Modifier.clickable { navController.navigate(Screen.NewsScreen.createRoute(title)) }
    ){
        Column(
            modifier = Modifier
                .size(width = 160.dp, height = 185.dp)
                .background(color = colorResource(id = color)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

             Image(
                 painter = painterResource(id = image),
                 contentDescription = "cardImage",
                 modifier = Modifier.size(130.dp)
             )

             Text(
                 text = title,
                 fontSize = 22.sp,
                 fontFamily = customFontFamily,
                 color = colorResource(id = R.color.white),
                 modifier = Modifier
                     .fillMaxWidth()
                     .wrapContentSize(align = Alignment.Center)
             )
        }
        
    }
}

@Composable
fun RightHomeCard(color : Int, image : Int, title : String, navController: NavHostController) {
    val customFontFamily = FontFamily(
        Font(R.font.exosemibold, FontWeight.SemiBold),
    )
    Card(
        shape = RoundedCornerShape(
            topStart = 24.dp,
            topEnd = 24.dp,
            bottomStart = 0.dp,
            bottomEnd = 24.dp,
        ),
        modifier = Modifier
            .clickable { navController.navigate(Screen.NewsScreen.createRoute(title)) }
    ){
        Column(
            modifier = Modifier
                .size(width = 160.dp, height = 185.dp)
                .background(color = colorResource(id = color)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = image),
                contentDescription = "cardImage",
                modifier = Modifier.size(130.dp)
            )

            Text(
                text = title,
                fontSize = 22.sp,
                fontFamily = customFontFamily,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center)
            )
        }

    }
}

