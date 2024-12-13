package com.sumpaulo.ecommerceapp.presentation.screns.auth.register

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumpaulo.ecommerceapp.presentation.components.DefaultTopBar
import com.sumpaulo.ecommerceapp.presentation.screns.auth.register.components.RegisterContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            DefaultTopBar(title = "Registro", upAvailable = true, navController=navController)
        },


    ) { paddingValues ->
        RegisterContent(paddingValues)
    }
}

@Preview
@Composable
fun preview(){
    RegisterScreen(rememberNavController())
}