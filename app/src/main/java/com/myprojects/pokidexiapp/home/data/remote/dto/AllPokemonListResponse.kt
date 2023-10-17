package com.myprojects.pokidexiapp.home.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.myprojects.pokidexiapp.home.domain.model.PokemonCardItemInfo

data class AllPokemonListResponse(

  @field:SerializedName("next")
  val next: String? = null,

  @field:SerializedName("previous")
  val previous: Any? = null,

  @field:SerializedName("count")
  val count: Int? = null,

  @field:SerializedName("results")
  val results: List<ResultsItem>? = null
)

data class ResultsItem(

  @field:SerializedName("name")
  val name: String?,

  @field:SerializedName("url")
  val url: String? = null
) {
	object PokemonMapper {
		fun toPokemonCardItemInfo(resultsItem: ResultsItem) = PokemonCardItemInfo(
			name = resultsItem.name.orEmpty(),
			apiUrl = resultsItem.url.orEmpty()
		)
	}
}
