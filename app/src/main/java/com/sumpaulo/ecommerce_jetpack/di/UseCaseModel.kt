package com.sumpaulo.ecommerce_jetpack.di

import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.sumpaulo.ecommerce_jetpack.data.service.AuthService
import com.sumpaulo.ecommerce_jetpack.domain.repository.AuthRepository
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.AuthUseCase
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModel {

    @Provides
    @Singleton
   fun  provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
       login = LoginUseCase(authRepository)
   )
}