package com.sumpaulo.ecommerceapp.domain.repository

import com.sumpaulo.ecommerceapp.domain.model.User
import com.sumpaulo.ecommerceapp.domain.util.Response

interface AuthRepository {
    suspend fun login(email: String, password: String): Response<User>
}