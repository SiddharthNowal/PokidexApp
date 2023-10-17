package com.myprojects.pokidexiapp.home.domain.model

import androidx.compose.ui.graphics.Color
import com.myprojects.pokidexiapp.utils.theme.ColorGreenLight
import com.myprojects.pokidexiapp.utils.theme.ColorLime

data class PokemonCardItemInfo(
  val name: String = "Bulbasaur",
  val region: String = "Kanto",
  val type: String = "Grass",
  val imageUrl: String = "https://e7.pngegg.com/pngimages/419/447/png-clipart-bulbasaur-from-pokemon-illustration-pokemon-go-pokemon-yellow-pikachu-ash-ketchum-bulbasaur-pokemon-vertebrate-fictional-character-thumbnail.png",
  var apiUrl: String = "",
  var backgroundColor: Color = ColorGreenLight,
  var pokemonTypeColor: Color = ColorLime,
)
