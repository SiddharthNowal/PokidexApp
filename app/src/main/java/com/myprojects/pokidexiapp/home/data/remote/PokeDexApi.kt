package com.myprojects.pokidexiapp.home.data.remote

import com.myprojects.pokidexiapp.home.data.remote.dto.AllPokemonListResponse
import com.myprojects.pokidexiapp.home.data.remote.dto.PokemonDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeDexApi {

  @GET("pokemon")
  suspend fun getPokemonList(
    @Query("limit") limit: Int,
    @Query("offset") offset: Int
  ): AllPokemonListResponse

  @GET("pokemon/{name}")
  suspend fun getPokemonDetail(@Path("name") name: String): PokemonDetailResponse
}