package com.sumpaulo.ecommerce_jetpack.domain.model

data class AuthResponse(
    val user: User,
    val token: String
)