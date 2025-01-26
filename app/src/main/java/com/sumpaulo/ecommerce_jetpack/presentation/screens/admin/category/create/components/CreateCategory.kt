package com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import com.sumpaulo.ecommerce_jetpack.presentation.components.ProgressBar
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.Graph
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create.AdminCategoryCreateViewModel
import com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun CreateCategory(viewModel: AdminCategoryCreateViewModel = hiltViewModel ()){
    when(val response = viewModel.categoryResponse){
        Resource.Loading -> {
            ProgressBar()
        }

       is Resource.Success -> {
           Toast.makeText(LocalContext.current, "Categoria Atualizada Corretamente..." , Toast.LENGTH_LONG).show()
           viewModel.clearForm()
       }

       is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message , Toast.LENGTH_LONG).show()
        }
        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current, "Ocorreu um erro, tente mais tarde", Toast.LENGTH_LONG).show()
            }
        }
    }
}