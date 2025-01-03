package com.sumpaulo.ecommerce_jetpack.data.repository

import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.repository.AuthRepository
import com.sumpaulo.ecommerce_jetpack.domain.util.Response

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Response<AuthResponse> {

        return try {
            val result = authRemoteDataSource.login(email, password)
            Response.Success(result.body()!!)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}

