package com.example.newsapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsAppBar(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.news),
            style = TextStyle(color = Color.White, fontSize = 22.sp)
        )
    }, modifier = Modifier.clip(
        RoundedCornerShape(
            topStart = 0.dp, topEnd = 0.dp, bottomStart = 30.dp, bottomEnd = 30.dp
        )
    ), colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = Color(0xFF39A552), navigationIconContentColor = Color.White
    ), navigationIcon = {
        IconButton(onClick = {
            scope.launch { drawerState.open() }

        }) {
            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Icon Menu"
            )
        }
    }
    )
}
