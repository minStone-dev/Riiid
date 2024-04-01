package com.minstone.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.minstone.presentation.ui.screen.PostListScreen
import com.minstone.presentation.ui.theme.RiiidTheme
import com.minstone.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

enum class MainPage(val value: String) {
    PostList("PostList"),
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            RiiidTheme { _ ,_ ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding()
                ) {
                    NavHost(
                        navController = navController as NavHostController,
                        startDestination = MainPage.PostList.name
                    ) {
                        composable(MainPage.PostList.name) {
                            PostListScreen(
                                viewModel = mainViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}