package com.sumpaulo.ecommerce_jetpack.presentation.screens.client.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.client.ClientScreen

import androidx.compose.runtime.getValue

@Composable()
fun ClientBottomBar(navController:NavHostController) {

    val screens = listOf(
        ClientScreen.ProductList,
        ClientScreen.CategoryList,
        ClientScreen.Profile
    )

    val navBackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomNavigation() {
            screens.forEach { screen ->
                ClientBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}