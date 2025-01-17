package com.sumpaulo.ecommerce_jetpack.di

import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.UserRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSourceImpl.UserRemoteDataSourceImpl
import com.sumpaulo.ecommerce_jetpack.data.service.AuthService
import com.sumpaulo.ecommerce_jetpack.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModel {
    @Provides
    fun provideAuthRepositoryDataSource(authService: AuthService) : AuthRemoteDataSource =
        AuthRemoteDataSourceImpl(authService)


    @Provides
    fun provideUserRemoteDataSource(userService: UserService): UserRemoteDataSource =
        UserRemoteDataSourceImpl(userService)
}