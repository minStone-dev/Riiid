package com.minstone.presentation.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.minstone.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
fun PostListScreen(
    viewModel: MainViewModel
) {
    Button(onClick = {     viewModel.getPostList()}) {

    }
}