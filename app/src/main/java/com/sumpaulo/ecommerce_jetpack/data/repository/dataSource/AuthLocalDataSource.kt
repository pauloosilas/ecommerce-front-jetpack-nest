package com.sumpaulo.ecommerce_jetpack.data.repository.dataSource

import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {
    suspend fun saveSession(authResponse: AuthResponse)
    fun getSessionData(): Flow<AuthResponse>

    suspend fun logout()
}