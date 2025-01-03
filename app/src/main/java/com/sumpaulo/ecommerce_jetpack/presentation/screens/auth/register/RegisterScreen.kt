package com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register.components.Register
import com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register.components.RegisterContent

@Composable
fun RegisterScreen(navController: NavHostController){
    Scaffold() {
        RegisterContent(it)
    }

    Register(navController = navController)
}


@Composable
@Preview(showSystemUi = true)
fun RegisterScreenPreview(){
    RegisterScreen(navController = rememberNavController())
}