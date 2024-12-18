package com.sumpaulo.ecommerceapp.di

import com.sumpaulo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerceapp.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.sumpaulo.ecommerceapp.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModel {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource =
        AuthRemoteDataSourceImpl(authService)
}