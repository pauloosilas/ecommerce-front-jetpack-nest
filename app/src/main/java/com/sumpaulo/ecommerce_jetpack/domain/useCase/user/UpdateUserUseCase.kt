package com.sumpaulo.ecommerce_jetpack.domain.useCase.user

import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.domain.repository.UserRepository

class UpdateUserUseCase constructor(private val repository: UserRepository) {

    suspend operator fun invoke(id:String, user:User) = repository.update(id, user)
}