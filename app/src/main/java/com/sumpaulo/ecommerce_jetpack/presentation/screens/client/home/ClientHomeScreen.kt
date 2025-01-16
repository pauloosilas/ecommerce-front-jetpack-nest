package com.sumpaulo.ecommerce_jetpack.presentation.screens.client.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.graph.client.ClientNavGraph
import com.sumpaulo.ecommerce_jetpack.presentation.screens.client.home.components.ClientBottomBar

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun ClientHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = { ClientBottomBar(navController) }
    ) { paddingValues ->
        ClientNavGraph(navController = navController)
    }
}