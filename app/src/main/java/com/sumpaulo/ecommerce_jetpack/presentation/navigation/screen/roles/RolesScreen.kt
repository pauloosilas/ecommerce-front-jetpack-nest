package com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.roles

import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.auth.AuthScreen

sealed class RolesScreen(val route: String){
    object Roles: RolesScreen("roles")
}