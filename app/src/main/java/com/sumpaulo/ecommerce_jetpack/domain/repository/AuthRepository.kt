package com.sumpaulo.ecommerce_jetpack.domain.repository

import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password:String): Resource<AuthResponse>
    suspend fun register(user: User): Resource<AuthResponse>

    suspend fun saveSession(authResponse: AuthResponse)
    fun getSessionData(): Flow<AuthResponse>

    suspend fun logout()
}