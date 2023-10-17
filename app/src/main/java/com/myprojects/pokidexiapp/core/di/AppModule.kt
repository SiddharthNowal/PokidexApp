package com.myprojects.pokidexiapp.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Singleton
  @Provides
  fun providesGsonRetrofit(
    httpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
  ): Retrofit = Retrofit.Builder()
    .baseUrl("https://pokeapi.co/api/v2/")
    .client(httpClient)
    .addConverterFactory(gsonConverterFactory).build()

  @Singleton
  @Provides
  fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder()
      .addInterceptor(interceptor)
      .retryOnConnectionFailure(true)
      .build()

  @Singleton
  @Provides
  fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
  }

  @Provides
  @Singleton
  fun provideGsonConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()
}