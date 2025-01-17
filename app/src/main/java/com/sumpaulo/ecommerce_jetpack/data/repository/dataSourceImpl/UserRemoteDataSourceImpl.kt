package com.sumpaulo.ecommerce_jetpack.data.repository.dataSourceImpl

import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.UserRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.data.service.AuthService
import com.sumpaulo.ecommerce_jetpack.data.service.UserService
import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.model.User
import retrofit2.Response

class UserRemoteDataSourceImpl(private val userService: UserService): UserRemoteDataSource {
    override suspend fun update(id:String, user: User): Response<User>  = userService.update(id , user)

}