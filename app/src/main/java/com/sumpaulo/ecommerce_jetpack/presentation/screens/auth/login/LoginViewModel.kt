package com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.domain.util.Response
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")
        private set

    //LOGIN RESPONSE
    var loginResponse by mutableStateOf<Response<User>?>(null)
    private set

    fun login() = viewModelScope.launch{
        if(isValidForm()){
            loginResponse = Response.Loading
            val result = authUseCase.login(state.email, state.password)
            loginResponse = result
            Log.d("LoginViewModel", "Response: ${loginResponse}")
        }

    }

    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password:String){
        state = state.copy(password = password)
    }


    fun isValidForm(): Boolean {

        if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "Email invalido!"
            return false

        }else
            if(state.password.length < 6){
                errorMessage = "A senha deve ter pelo menos 6 caracteres"
                return false

            }
            errorMessage = ""
          return true

    }

}