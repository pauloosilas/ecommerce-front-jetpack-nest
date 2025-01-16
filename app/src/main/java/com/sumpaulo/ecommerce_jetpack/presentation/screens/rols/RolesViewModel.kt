package com.sumpaulo.ecommerce_jetpack.presentation.screens.rols

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

import androidx.compose.runtime.getValue;
import androidx.compose.runtime.setValue;

@HiltViewModel
class RolesViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel(){

    var authResponse by mutableStateOf(AuthResponse());

    init{
        getSessionData()
    }
    fun getSessionData() = viewModelScope.launch{
        authUseCase.getSessionData().collect(){ data ->

            if(!data.token.isNullOrBlank()){
                authResponse = data
            }

        }
    }

}