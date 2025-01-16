package com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.info

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.info.components.ProfileContent

@Composable
fun ProfileScreen(navController: NavHostController){
    Scaffold() {
        ProfileContent(paddingValues = it, navController = navController)
    }
}