package com.sumpaulo.ecommerce_jetpack.data.repository.dataSourceImpl

import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.data.service.AuthService
import com.sumpaulo.ecommerce_jetpack.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {
    override suspend fun login(email:String, password:String) = authService.login(email, password)
}