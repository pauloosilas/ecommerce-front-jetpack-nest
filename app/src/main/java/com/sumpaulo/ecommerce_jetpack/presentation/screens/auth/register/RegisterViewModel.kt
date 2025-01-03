package com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumpaulo.ecommerce_jetpack.domain.repository.AuthRepository
import com.sumpaulo.ecommerce_jetpack.domain.useCase.auth.AuthUseCase
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.model.User

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    fun register() = viewModelScope.launch {
      if(isValidForm()){
          val user = User(
              name = state.name,
              lastname = state.phone,
              phone = state.phone,
              email = state.email,
              password = state.password
          )
          registerResponse = Resource.Loading
          val result = authUseCase.register(user)
          registerResponse = result //data ou error
      }
    }

    var state by mutableStateOf(RegisterState())
        private set



    var errorMessage by mutableStateOf("")


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

    fun isValidForm(): Boolean {
        if(state.name == ""){
            errorMessage = "Adicione um nome!"
            return false
        } else
            if(state.lastname == ""){
                errorMessage = "Adicione um sobrenome!"
                return false
            } else
                if(state.phone == ""){
                    errorMessage = "Adicione um telefone!"
                    return false
                } else
                    if(state.email == ""){
                        errorMessage = "Adicione um email!"
                        return false
                    } else
                        if(state.password == ""){
                            errorMessage = "Adicione uma senha!"
                            return false
                        } else
                            if(state.confirmPassword == ""){
                                errorMessage = "Confirme a senha!"
                                return false
                            } else
                                if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
                                    errorMessage = "Email invalido!"
                                    return false
                                }else
                                    if(state.password.length < 6){
                                        errorMessage = "A senha deve ter pelo menos 6 caracteres"
                                        return false
                                    }
                                    else
                                        if(state.password != state.confirmPassword){
                                            errorMessage = "Senha incorreta!"
                                            return false
                                        }


       return true
    }

}