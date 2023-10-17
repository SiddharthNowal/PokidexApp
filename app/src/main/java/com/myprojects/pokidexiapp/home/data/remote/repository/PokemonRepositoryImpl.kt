package com.myprojects.pokidexiapp.home.data.remote.repository

import com.myprojects.pokidexiapp.home.data.remote.PokeDexApi
import com.myprojects.pokidexiapp.home.data.remote.dto.AllPokemonListResponse
import com.myprojects.pokidexiapp.home.data.remote.dto.PokemonDetailResponse
import com.myprojects.pokidexiapp.home.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val api: PokeDexApi) : PokemonRepository {

  override suspend fun getPokemonList(limit: Int, offset: Int): AllPokemonListResponse {
    return api.getPokemonList(limit, offset)
  }

  override suspend fun getPokemonDetail(name: String): PokemonDetailResponse {
    return api.getPokemonDetail(name)
  }
}