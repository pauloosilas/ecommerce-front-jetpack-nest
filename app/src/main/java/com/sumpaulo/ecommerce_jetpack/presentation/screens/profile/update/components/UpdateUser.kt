package com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import com.sumpaulo.ecommerce_jetpack.presentation.components.ProgressBar
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.Graph
import com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun UpdateUser(viewModel: ProfileUpdateViewModel = hiltViewModel ()){
    when(val response = viewModel.updateResponse){
        Resource.Loading -> {
            ProgressBar()
        }

       is Resource.Success -> {
           Log.d("update user", "Data: ${response.data}")
           viewModel.updateUseSession(response.data)
           Toast.makeText(LocalContext.current, "Dados Atualizados Com Sucesso" , Toast.LENGTH_LONG).show()
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