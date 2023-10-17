package com.myprojects.pokidexiapp.home.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myprojects.pokidexiapp.core.utils.Resource
import com.myprojects.pokidexiapp.home.domain.model.PokemonCardItemInfo
import com.myprojects.pokidexiapp.home.domain.use_case.GetAllPokemonsUseCase
import com.myprojects.pokidexiapp.home.presentation.model.FetchAllPokemonState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val getAllPokemonsUseCase: GetAllPokemonsUseCase
): ViewModel() {

  private val _state = mutableStateOf(FetchAllPokemonState())
  val allPokemonInfoState: State<FetchAllPokemonState> = _state

  init {
    getAllPokemons(10, 0)
  }

  private fun getAllPokemons(limit: Int, offset: Int) {
    getAllPokemonsUseCase(limit, offset).onEach { result ->
      _state.value = when(result) {
        is Resource.Error -> FetchAllPokemonState(
          error = result.message ?: "An Unexpected Error Occurred, Please Try Again Later"
        )
        is Resource.Loading -> FetchAllPokemonState(isLoading = true)
        is Resource.Success -> FetchAllPokemonState(
          pokemonInfoList = result.data ?: emptyList()
        )
      }
    }.launchIn(viewModelScope)
  }
}