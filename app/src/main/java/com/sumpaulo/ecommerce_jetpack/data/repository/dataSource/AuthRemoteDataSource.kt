package com.sumpaulo.ecommerce_jetpack.data.repository.dataSource

import com.sumpaulo.ecommerce_jetpack.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun login(email:String, password:String): Response<User>

}