package com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register.components.RegisterContent

@Composable
fun RegisterScreen(){
    Scaffold() {
        RegisterContent(it)
    }
}


@Composable
@Preview(showSystemUi = true)
fun RegisterScreenPreview(){
    RegisterScreen()
}