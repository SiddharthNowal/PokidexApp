package com.myprojects.pokidexiapp.home.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myprojects.pokidexiapp.home.presentation.screens.AccountScreen
import com.myprojects.pokidexiapp.home.presentation.screens.FavouritesScreen
import com.myprojects.pokidexiapp.home.presentation.screens.HomeScreen
import com.myprojects.pokidexiapp.home.presentation.screens.RegionsScreen

@Composable
fun HomeNavHost(navHostController: NavHostController) {
  NavHost(navHostController, startDestination = "home") {
    composable("home") {
      HomeScreen()
    }
    composable("regions") {
      RegionsScreen()
    }
    composable("favourites") {
      FavouritesScreen()
    }
    composable("account") {
      AccountScreen()
    }
  }
}