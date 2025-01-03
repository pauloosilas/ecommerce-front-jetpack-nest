package com.sumpaulo.ecommerce_jetpack.domain.useCase.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase
)