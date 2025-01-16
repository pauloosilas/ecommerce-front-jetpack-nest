package com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import com.sumpaulo.ecommerce_jetpack.domain.model.User

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var state by mutableStateOf(ProfileUpdateState())
        private set

    //Argumentos

    val data = savedStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    init{
        state = state.copy(
            name = user.name,
            lastname = user.lastname,
            phone = user.phone,
            image = user.image ?: ""
        )
    }

    fun onNameInput(input:String){
        state = state.copy(
            name = input
        )
    }

    fun onLastnameInput(input:String){
        state = state.copy(
            lastname = input
        )
    }

    fun onPhoneInput(input:String){
        state.copy(phone = input)
    }

    fun onImageInput(input:String){
        state.copy(image = input)
    }
}