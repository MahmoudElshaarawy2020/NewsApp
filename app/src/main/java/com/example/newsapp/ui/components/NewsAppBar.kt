package com.example.newsapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsAppBar(sideMenuIcon : Boolean, title : String) {

    val customFontFamily = FontFamily(
        Font(R.font.poppinssemibold, FontWeight.SemiBold),
    )

    Surface(
        shape = RoundedCornerShape(
            bottomStart = 45.dp,
            bottomEnd = 45.dp
        ),
        color = colorResource(id = R.color.green), // Background color for the Surface
        shadowElevation = 4.dp // Optional shadow elevation
    ) {
        TopAppBar(
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                    ) {

                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "Menu",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                            .padding(start = 8.dp)
                            .weight(0.25f)

                    )

                    Text(
                        text = title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontFamily = customFontFamily,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f) // Allocate remaining space for title
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                            .padding(end = 8.dp)
                            .weight(0.3f)
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent
            )
        )
    }

}

@Preview
@Composable
private fun NewsAppBarPreview() {
    NewsAppBar(false, " News App")
}