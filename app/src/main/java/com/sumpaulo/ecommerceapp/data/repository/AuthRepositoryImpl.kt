package com.sumpaulo.ecommerceapp.data.repository

import com.sumpaulo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerceapp.domain.model.User
import com.sumpaulo.ecommerceapp.domain.repository.AuthRepository
import com.sumpaulo.ecommerceapp.domain.util.Response

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Response<User> {
      return try {
        val result = authRemoteDataSource.login(email, password)
          Response.Success(result.body()!!)
      }catch (e: Exception){
          e.printStackTrace()
          Response.Failure(e)
      }
    }
}