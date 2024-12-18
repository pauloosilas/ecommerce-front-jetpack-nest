package com.sumpaulo.ecommerceapp.data.repository.dataSource

import com.sumpaulo.ecommerceapp.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun login(email: String, password:String): Response<User>
}