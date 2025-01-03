package com.sumpaulo.ecommerce_jetpack.di

import com.sumpaulo.ecommerce_jetpack.core.Config
import com.sumpaulo.ecommerce_jetpack.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
      return  Retrofit.Builder()
          .baseUrl(Config.BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
    }


    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService{
        return retrofit.create(AuthService::class.java)
    }
}