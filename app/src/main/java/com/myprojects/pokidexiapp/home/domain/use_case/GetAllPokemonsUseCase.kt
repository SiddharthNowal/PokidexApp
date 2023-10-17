package com.myprojects.pokidexiapp.home.domain.use_case

import android.util.Log
import com.myprojects.pokidexiapp.core.utils.Resource
import com.myprojects.pokidexiapp.home.data.remote.dto.ResultsItem
import com.myprojects.pokidexiapp.home.domain.model.PokemonCardItemInfo
import com.myprojects.pokidexiapp.home.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllPokemonsUseCase @Inject constructor(private val repository: PokemonRepository) {

  operator fun invoke(limit: Int, offset: Int): Flow<Resource<List<PokemonCardItemInfo>>> {
    return flow {
      try {
        emit(Resource.Loading())
        val allPokemonListResponse = repository.getPokemonList(limit, offset)
        val pokemonInfoList = allPokemonListResponse.results?.let {
         it.map { resultsItem ->
           ResultsItem.PokemonMapper.toPokemonCardItemInfo(resultsItem)
         }.sortedBy { item -> item.name }
        } ?: run {
          emptyList()
        }
        emit(Resource.Success(pokemonInfoList))
      } catch (e: Exception) {
        Log.e("Api Call Exception: ", e.message.toString())
        emit(Resource.Error(data = emptyList(), message = e.message.toString()))
      }
    }
  }
}