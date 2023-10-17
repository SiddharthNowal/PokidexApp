package com.myprojects.pokidexiapp.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.myprojects.pokidexiapp.utils.theme.ColorWhite

@Composable
fun FavouritesScreen(){
  Surface(modifier = Modifier
    .background(ColorWhite)
    .fillMaxSize()) {
    Text(text = "Favourites Screen")
  }
}


@Preview
@Composable
fun PreviewFavouritesScreen() {
  FavouritesScreen()
}