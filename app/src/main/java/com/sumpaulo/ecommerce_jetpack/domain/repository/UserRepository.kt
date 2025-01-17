package com.sumpaulo.ecommerce_jetpack.domain.repository

import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import java.io.File

interface UserRepository {
    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithImage(id:String, user:User, file: File): Resource<User>
}