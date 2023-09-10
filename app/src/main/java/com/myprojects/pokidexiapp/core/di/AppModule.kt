package com.myprojects.pokidexiapp.core.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Singleton
  @Provides
  fun providesGsonRetrofit(
    httpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory) = Retrofit.Builder()
    .baseUrl("https://pokeapi.glitch.me")
    .client(httpClient)
    .addConverterFactory(gsonConverterFactory)
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

  @Provides
  @Singleton
  fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(httpLoggingInterceptor)
    httpClient.retryOnConnectionFailure(true)
    return httpClient

  }

  @Provides
  @Singleton
  fun provideGsonConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()
}