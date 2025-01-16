package com.sumpaulo.ecommerce_jetpack.data.repository

import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthLocalDataSource
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.model.ErrorResponse
import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.domain.repository.AuthRepository
import com.sumpaulo.ecommerce_jetpack.domain.util.ConvertErrorBody
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import com.sumpaulo.ecommerce_jetpack.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
    ): AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Resource<AuthResponse>  = ResponseToRequest.send(
        authRemoteDataSource.login(email, password)
    )

    override suspend fun register(user: User): Resource<AuthResponse> =
        ResponseToRequest.send(
            authRemoteDataSource.register(user)
        )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()

    override suspend fun logout()  = authLocalDataSource.logout()


}

