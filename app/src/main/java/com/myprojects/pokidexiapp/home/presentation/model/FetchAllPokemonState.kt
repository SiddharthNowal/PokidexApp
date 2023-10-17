package com.myprojects.pokidexiapp.home.presentation.model

import com.myprojects.pokidexiapp.home.domain.model.PokemonCardItemInfo

data class FetchAllPokemonState(
  val isLoading: Boolean = false,
  val pokemonInfoList: List<PokemonCardItemInfo> = listOf(),
  val error: String = ""
)
