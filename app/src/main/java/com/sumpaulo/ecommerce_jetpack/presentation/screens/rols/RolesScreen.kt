package com.sumpaulo.ecommerce_jetpack.presentation.screens.rols

import DefaultTopBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import androidx.compose.material3.Scaffold
import com.sumpaulo.ecommerce_jetpack.presentation.screens.rols.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController){
    Scaffold(
        topBar = {DefaultTopBar(title = "Selecionar Role")}
    ) {
        RolesContent(it, navController)
    }
}