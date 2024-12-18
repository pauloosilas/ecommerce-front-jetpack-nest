package com.sumpaulo.ecommerceapp.domain.useCase.auth

import com.sumpaulo.ecommerceapp.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email:String, password:String) = repository.login(email,password)
}