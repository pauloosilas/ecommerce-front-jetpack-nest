package com.sumpaulo.ecommerceapp.presentation.screns.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumpaulo.ecommerceapp.presentation.screns.auth.login.components.LoginContent
import com.sumpaulo.ecommerceapp.presentation.ui.theme.EcommerceAppTheme

@Composable
fun LoginScreen(navController: NavHostController){
    Scaffold(){ paddingValues ->
        LoginContent(navController = navController, paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview(){
    EcommerceAppTheme {
        LoginScreen(rememberNavController())
    }
}