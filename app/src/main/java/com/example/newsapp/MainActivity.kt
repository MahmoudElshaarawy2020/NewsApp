package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.navigation.AppNavigation
import com.example.newsapp.ui.components.DrawerBody
import com.example.newsapp.ui.components.DrawerHeader
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {

                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val navController = rememberNavController()
                val scope = rememberCoroutineScope()


                ModalNavigationDrawer(drawerContent = {
                    Column(modifier = Modifier.fillMaxSize()) {
                        DrawerHeader()
                        DrawerBody(navController) {
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    }
                }, drawerState = drawerState) {
                    AppNavigation(drawerState)
                }


            }
        }
    }
}

