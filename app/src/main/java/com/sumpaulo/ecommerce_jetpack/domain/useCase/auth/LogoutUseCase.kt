package com.sumpaulo.ecommerce_jetpack.domain.useCase.auth

import com.sumpaulo.ecommerce_jetpack.domain.repository.AuthRepository

class LogoutUseCase constructor(private val repository: AuthRepository){
    suspend operator fun invoke() = repository.logout()
}