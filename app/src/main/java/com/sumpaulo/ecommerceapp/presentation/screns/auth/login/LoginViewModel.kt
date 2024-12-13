package com.sumpaulo.ecommerceapp.presentation.screns.auth.login

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel(){

    var state by mutableStateOf(LoginState())
    private set

    var isValidForm by mutableStateOf(false)
    private set

    var errorMessage by mutableStateOf("")
    private set

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password:String){
        state = state.copy(password = password)
    }

    fun validateForm() = viewModelScope.launch {
        print("teste")
        if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "Email invalido!"
        }else
        if(state.password.length < 6){
            errorMessage = "A senha deve ter pelo menos 6 caracteres"
        }

        delay(3000)
        errorMessage = ""
    }


}