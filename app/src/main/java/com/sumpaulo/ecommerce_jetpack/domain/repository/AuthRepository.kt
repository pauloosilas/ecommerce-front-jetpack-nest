package com.sumpaulo.ecommerce_jetpack.domain.repository

import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.util.Response

interface AuthRepository {
    suspend fun login(email: String, password:String): Response<AuthResponse>
}