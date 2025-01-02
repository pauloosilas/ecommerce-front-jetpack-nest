package com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.login.components.LoginContent
import com.sumpaulo.ecommerce_jetpack.presentation.ui.theme.EcommercejetpackTheme

@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold(){paddingValues ->
        LoginContent(paddingValues, navController)
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DefaultPreview(){
    EcommercejetpackTheme {
        LoginScreen(navController = rememberNavController())
    }
}