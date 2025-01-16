package com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.graph.admin.AdminNavGraph
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.home.components.AdminBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = { AdminBottomBar(navController = navController) }
    ) {
        AdminNavGraph(navController = navController)

    }
}