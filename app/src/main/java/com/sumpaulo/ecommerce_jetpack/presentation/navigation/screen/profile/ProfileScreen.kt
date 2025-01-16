package com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.profile

import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.auth.AuthScreen

sealed class ProfileScreen(val route: String){
   object ProfileUpdate: ProfileScreen(route = "profile/update/{user}")
}