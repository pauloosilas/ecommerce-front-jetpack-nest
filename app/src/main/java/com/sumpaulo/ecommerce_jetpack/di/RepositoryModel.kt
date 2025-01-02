package com.sumpaulo.ecommerce_jetpack.di

import com.sumpaulo.ecommerce_jetpack.data.repository.AuthRepositoryImpl
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.sumpaulo.ecommerce_jetpack.data.service.AuthService
import com.sumpaulo.ecommerce_jetpack.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModel {
    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource)
}