package com.sumpaulo.ecommerce_jetpack.domain.useCase.auth

import com.sumpaulo.ecommerce_jetpack.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}