package com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update

import android.content.Context
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
import com.sumpaulo.ecommerce_jetpack.presentation.util.ComposeFileProvider
import com.sumpaulo.ecommerce_jetpack.presentation.util.ResultingActivityHandler
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
): ViewModel() {

    var state by mutableStateOf(ProfileUpdateState())
        private set

    //Argumentos

    val data = savedStateHandle.get<String>("user")
    val user = User.fromJson(data!!)


    //imagens
    var file: File? = null;
    val resultActivityHandler = ResultingActivityHandler()


    init{
        state = state.copy(
            name = user.name,
            lastname = user.lastname,
            phone = user.phone,
            image = user.image ?: ""
        )
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultActivityHandler.getContent("image/*")
        if(result != null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image =  result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultActivityHandler.takePicturePreview()
        if(result != null){
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
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