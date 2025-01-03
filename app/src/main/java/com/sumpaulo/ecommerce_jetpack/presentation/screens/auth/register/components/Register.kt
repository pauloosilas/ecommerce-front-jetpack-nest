package com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import com.sumpaulo.ecommerce_jetpack.presentation.components.ProgressBar
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.AuthScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navController: NavHostController, viewModel: RegisterViewModel = hiltViewModel()){
    when(val response = viewModel.registerResponse){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AuthScreen.Home.route)
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current, "Error desconhecido", Toast.LENGTH_LONG).show()
            }
        }
    }
}