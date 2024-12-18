package com.sumpaulo.ecommerceapp.data.repository.dataSourceImpl

import com.sumpaulo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerceapp.data.service.AuthService
import com.sumpaulo.ecommerceapp.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

    override suspend fun login(email: String, password:String) = authService.login(email, password)
}