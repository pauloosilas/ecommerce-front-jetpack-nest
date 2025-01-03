package com.sumpaulo.ecommerce_jetpack.domain.useCase.auth

import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.domain.repository.AuthRepository

class RegisterUseCase(private val repository:  AuthRepository) {
    suspend operator fun invoke(user: User) = repository.register(user)
}