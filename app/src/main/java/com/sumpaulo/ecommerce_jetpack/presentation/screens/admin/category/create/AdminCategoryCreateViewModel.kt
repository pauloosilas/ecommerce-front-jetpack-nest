package com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.sumpaulo.ecommerce_jetpack.domain.model.Category
import com.sumpaulo.ecommerce_jetpack.domain.useCase.categories.CategoriesUseCases
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create.mapper.toCategory
import com.sumpaulo.ecommerce_jetpack.presentation.util.ComposeFileProvider
import com.sumpaulo.ecommerce_jetpack.presentation.util.ResultingActivityHandler
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject


@HiltViewModel
class AdminCategoryCreateViewModel @Inject constructor(
    private val categoriesUseCases: CategoriesUseCases,
    @ApplicationContext private val context: Context
): ViewModel() {

    var state by mutableStateOf(AdminCategoryCreateState())
        private set

    var categoryResponse by mutableStateOf<Resource<Category>?>(null)
        private set

    val resultActivityHandler = ResultingActivityHandler()
    var file: File? = null

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

    fun createCategory() = viewModelScope.launch {
        if(file != null){
            categoryResponse = Resource.Loading
            val result = categoriesUseCases.createCategory(state.toCategory(), file!!)
            categoryResponse = result
        }
    }

    fun clearForm() {
        state = state.copy(
            name = "",
            description = "",
            image = ""
        )
        categoryResponse = null
    }

    fun onNameInput(input:String){
        state = state.copy(
            name = input
        )
    }

    fun onDescriptionInput(input:String){
        state = state.copy(
            description = input
        )
    }

}