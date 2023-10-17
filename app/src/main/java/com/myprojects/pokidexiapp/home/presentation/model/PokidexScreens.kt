package com.myprojects.pokidexiapp.home.presentation.model

sealed class PokidexScreens(val route: String) {
  object HomeScreen : PokidexScreens("home")
  object RegionsScreen : PokidexScreens("regions")
  object FavouritesScreen : PokidexScreens("favourites")
  object AccountScreen : PokidexScreens("account")
}
