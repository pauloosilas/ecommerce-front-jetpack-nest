package com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.info

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.sumpaulo.ecommerce_jetpack.domain.model.User

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    init{
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
            authUseCase.getSessionData().collect(){ data ->
                user = data.user
            }
    }

    fun logout() = viewModelScope.launch{
        authUseCase.logout()
    }
}