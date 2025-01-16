package com.sumpaulo.ecommerce_jetpack.di

import com.sumpaulo.ecommerce_jetpack.core.Config
import com.sumpaulo.ecommerce_jetpack.data.datastore.AuthDataStore
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthLocalDataSource
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSourceImpl.AuthLocalDataSourceImpl
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
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDataStore: AuthDataStore): AuthLocalDataSource =
        AuthLocalDataSourceImpl(authDataStore)



}