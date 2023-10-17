package com.myprojects.pokidexiapp.home.domain.repository

import com.myprojects.pokidexiapp.home.data.remote.dto.AllPokemonListResponse
import com.myprojects.pokidexiapp.home.data.remote.dto.PokemonDetailResponse

interface PokemonRepository {

  suspend fun getPokemonList(limit: Int, offset: Int): AllPokemonListResponse

  suspend fun getPokemonDetail(name: String): PokemonDetailResponse
}