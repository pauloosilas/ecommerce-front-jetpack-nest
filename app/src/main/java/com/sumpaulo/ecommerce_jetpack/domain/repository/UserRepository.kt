package com.sumpaulo.ecommerce_jetpack.domain.repository

import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource

interface UserRepository {
    suspend fun update(id: String, user: User): Resource<User>
}