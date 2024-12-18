package com.sumpaulo.ecommerceapp.di

import com.sumpaulo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerceapp.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.sumpaulo.ecommerceapp.data.service.AuthService
import com.sumpaulo.ecommerceapp.domain.repository.AuthRepository
import com.sumpaulo.ecommerceapp.domain.useCase.auth.AuthUseCase
import com.sumpaulo.ecommerceapp.domain.useCase.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository)
    )
}