package com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import com.sumpaulo.ecommerce_jetpack.presentation.components.ProgressBar
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.AuthScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel ()){
    when(val response = viewModel.loginResponse){
        Resource.Loading -> {
            ProgressBar()
        }

       is Resource.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AuthScreen.Home.route)
            }
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