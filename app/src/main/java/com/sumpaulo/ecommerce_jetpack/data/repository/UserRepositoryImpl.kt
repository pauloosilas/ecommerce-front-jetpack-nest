package com.sumpaulo.ecommerce_jetpack.data.repository

import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthLocalDataSource
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.AuthRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.UserRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.model.ErrorResponse
import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.domain.repository.AuthRepository
import com.sumpaulo.ecommerce_jetpack.domain.repository.UserRepository
import com.sumpaulo.ecommerce_jetpack.domain.util.ConvertErrorBody
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import com.sumpaulo.ecommerce_jetpack.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.File
import java.io.IOException

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource,
    ): UserRepository {

    override suspend fun update(id: String, user: User): Resource<User> =
        ResponseToRequest.send(
            userRemoteDataSource.update(id, user)
        )

    override suspend fun updateWithImage(
        id: String,
        user: User,
        file: File
    ) = ResponseToRequest.send(
        userRemoteDataSource.updateWithImage(id, user,file)
    )


}

