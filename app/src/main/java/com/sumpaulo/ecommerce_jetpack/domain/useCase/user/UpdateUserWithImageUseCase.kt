package com.sumpaulo.ecommerce_jetpack.domain.useCase.user

import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.domain.repository.UserRepository
import java.io.File

class UpdateUserWithImageUseCase constructor(private val repository: UserRepository) {

    suspend operator fun invoke(id:String, user:User, file: File) =
        repository.updateWithImage(id, user, file)
}