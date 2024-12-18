package com.sumpaulo.ecommerceapp.presentation.screns.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.sumpaulo.ecommerceapp.domain.model.User
import com.sumpaulo.ecommerceapp.domain.useCase.auth.AuthUseCase
import com.sumpaulo.ecommerceapp.domain.util.Response
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel(){

    var state by mutableStateOf(LoginState())
    private set

    var isValidFormMut by mutableStateOf(false)
    private set

    var errorMessage by mutableStateOf("")
    private set

    var loginResponse by mutableStateOf<Response<User>?>(null)
    private set

    fun login() = viewModelScope.launch{
        if(isValidForm()){
            loginResponse = Response.Loading
            val result = authUseCase.login(state.email, state.password)
            loginResponse = result
            Log.d("LoginViewModel","Response: ${loginResponse}")
        }

    }

    fun onEmailInput(email: String){
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


        return true
    }


}