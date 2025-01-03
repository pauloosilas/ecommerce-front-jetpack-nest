package com.sumpaulo.ecommerce_jetpack.domain.repository

import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource

interface AuthRepository {
    suspend fun login(email: String, password:String): Resource<AuthResponse>

    suspend fun register(user: User): Resource<AuthResponse>
}