package com.sumpaulo.ecommerceapp.di

import com.sumpaulo.ecommerceapp.data.repository.AuthRepositoryImpl
import com.sumpaulo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerceapp.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.sumpaulo.ecommerceapp.data.service.AuthService
import com.sumpaulo.ecommerceapp.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource)
}