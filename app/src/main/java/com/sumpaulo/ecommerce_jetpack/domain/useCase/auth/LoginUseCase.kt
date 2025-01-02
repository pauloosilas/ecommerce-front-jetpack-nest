package com.sumpaulo.ecommerce_jetpack.domain.useCase.auth

import com.sumpaulo.ecommerce_jetpack.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email:String, password:String) = repository.login(email, password)
}