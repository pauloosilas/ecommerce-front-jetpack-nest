package com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.compareTo

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set


    var isValidForm by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf("")
        private set

    fun onNameInput(input:String){
        state = state.copy(name = input)
    }

    fun onLastNameInput(input:String){
        state = state.copy(lastname = input)
    }

    fun onEmailInput(input:String){
        state = state.copy(email = input)
    }

    fun onPhoneInput(input:String){
        state = state.copy(phone = input)
    }

    fun onPasswordInput(input:String){
        state = state.copy(password = input)
    }

    fun onConfirmPasswordInput(input:String){
        state = state.copy(confirmPassword = input)
    }

    fun validateForm() = viewModelScope.launch {
        if(state.name == ""){
            errorMessage = "Adicione um nome!"
        } else
            if(state.lastname == ""){
                errorMessage = "Adicione um sobrenome!"
            } else
                if(state.phone == ""){
                    errorMessage = "Adicione um telefone!"
                } else
                    if(state.email == ""){
                        errorMessage = "Adicione um email!"
                    } else
                        if(state.password == ""){
                            errorMessage = "Adicione uma senha!"
                        } else
                            if(state.confirmPassword == ""){
                                errorMessage = "Confirme a senha!"
                            } else
                                if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
                                    errorMessage = "Email invalido!"
                                }else
                                    if(state.password.length < 6){
                                        errorMessage = "A senha deve ter pelo menos 6 caracteres"
                                    }
                                    else
                                        if(state.password != state.confirmPassword){
                                            errorMessage = "Senha incorreta!"
                                        }

        delay(3000)
        errorMessage = ""
    }

}