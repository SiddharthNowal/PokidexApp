package com.myprojects.pokidexiapp.home.di

import com.myprojects.pokidexiapp.home.data.remote.PokeDexApi
import com.myprojects.pokidexiapp.home.data.remote.repository.PokemonRepositoryImpl
import com.myprojects.pokidexiapp.home.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class HomeModule {

  @Provides @ViewModelScoped
  fun providePokeDexApi(retrofit: Retrofit) = retrofit.create(PokeDexApi::class.java)

  @Provides @ViewModelScoped
  fun providePokemonRepository(api: PokeDexApi): PokemonRepository = PokemonRepositoryImpl(api)

}