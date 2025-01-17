package com.sumpaulo.ecommerce_jetpack.data.repository.dataSourceImpl

import com.sumpaulo.ecommerce_jetpack.data.datastore.AuthDataStore
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthLocalDataSource
import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDataStore) : AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) = authDataStore.saveUser(authResponse)
    override suspend fun updateSession(user: User) = authDataStore.update(user)
    override fun getSessionData(): Flow<AuthResponse>  = authDataStore.getData()

    override suspend fun logout()  = authDataStore.delete()
}