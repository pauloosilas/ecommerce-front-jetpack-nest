package com.sumpaulo.ecommerce_jetpack.di

import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.sumpaulo.ecommerce_jetpack.data.service.AuthService
import com.sumpaulo.ecommerce_jetpack.domain.repository.AuthRepository
import com.sumpaulo.ecommerce_jetpack.domain.repository.UserRepository
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.AuthUseCase
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.GetSessionDataUseCase
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.LoginUseCase
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.LogoutUseCase
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.RegisterUseCase
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.SaveSessionUseCase
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.UpdateSessionUseCase
import com.sumpaulo.ecommerce_jetpack.domain.useCase.user.UpdateUserUseCase
import com.sumpaulo.ecommerce_jetpack.domain.useCase.user.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModel {

   @Provides
   fun  provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
       login = LoginUseCase(authRepository),
       register = RegisterUseCase(authRepository),
       saveSession = SaveSessionUseCase(authRepository),
       getSessionData = GetSessionDataUseCase(authRepository),
       logout = LogoutUseCase(authRepository),
       updateSession = UpdateSessionUseCase(authRepository)
   )

    @Provides
    fun provideUserUseCase(userRepository: UserRepository) = UserUseCase(
        updateUser = UpdateUserUseCase(userRepository)
    )

}