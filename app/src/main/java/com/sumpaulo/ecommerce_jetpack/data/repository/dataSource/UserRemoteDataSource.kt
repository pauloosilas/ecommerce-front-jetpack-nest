package com.sumpaulo.ecommerce_jetpack.data.repository.dataSource

import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.model.User
import retrofit2.Response

interface UserRemoteDataSource {
   suspend fun update(id:String, user: User):Response<User>
}