package com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.auth

sealed class AuthScreen(val route: String){
    object Login: AuthScreen("login")
    object Register: AuthScreen("register")
    object Home: AuthScreen("home")

}