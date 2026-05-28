package com.example.fotosdemarte.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(marsUiState: MarsUiState, modifier: Modifier) {
    when(marsUiState){
        is MarsUiState.Loading -> LoadingScreen()
        is MarsUiState.Success -> ResultScreen(marsUiState.photos.size.toString())
        is MarsUiState.Error -> ErrorScreen()
    }
}

@Composable
fun ResultScreen(text : String) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = text)
    }
}
@Composable
fun LoadingScreen() {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Loading....")
    }
}
@Composable
fun ErrorScreen() {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Alo con Dorian??")
    }
}