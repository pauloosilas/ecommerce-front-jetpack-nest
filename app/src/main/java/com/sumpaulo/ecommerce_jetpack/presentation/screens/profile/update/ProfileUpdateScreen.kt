package com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update

import DefaultTopBar
import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update.components.ProfileUpdateContent
import com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update.components.UpdateUser

@Composable
fun ProfileUpdateScreen(navController: NavHostController){

    Scaffold(
        topBar = { DefaultTopBar(title = "Atualizar usuário", navController=navController, upAvailable = true)}
    ) {
        ProfileUpdateContent(navController, paddingValues = it)
    }
    UpdateUser()
}