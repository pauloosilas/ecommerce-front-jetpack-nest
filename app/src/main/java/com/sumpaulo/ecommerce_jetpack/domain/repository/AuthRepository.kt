package com.sumpaulo.ecommerce_jetpack.domain.repository

import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.domain.util.Response

interface AuthRepository {
    suspend fun login(email: String, password:String): Response<User>
}