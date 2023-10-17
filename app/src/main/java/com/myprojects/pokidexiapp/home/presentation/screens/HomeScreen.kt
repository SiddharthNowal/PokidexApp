package com.myprojects.pokidexiapp.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.myprojects.pokidexiapp.home.presentation.viewmodel.HomeViewModel
import com.myprojects.pokidexiapp.utils.theme.ColorWhite

@Composable
fun HomeScreen(
  homeViewModel: HomeViewModel = hiltViewModel()
) {
  Box(
    modifier = Modifier
      .background(ColorWhite)
      .fillMaxSize()
  ) {
    val allPokemonState = homeViewModel.allPokemonInfoState.value
    if (allPokemonState.isLoading) {
      CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
    if (allPokemonState.error.isNotBlank()) {
      Snackbar(modifier = Modifier
        .align(Alignment.BottomCenter)
        .padding(bottom = 16.dp)) {
        Text(text = allPokemonState.error)
      }
    }
    LazyColumn {
      items(allPokemonState.pokemonInfoList) {
        PokemonInfoCard(pokemonItemInfo = it)
      }
    }
  }
}

@Preview
@Composable
fun PreviewHomeScreen() {
  HomeScreen()
}