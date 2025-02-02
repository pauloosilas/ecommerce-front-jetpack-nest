package com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.home.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.admin.AdminScreen

@Composable
fun RowScope.AdminBottomBarItem(
    screen: AdminScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        label = {
            Text(text=screen.title, color = Color.White)
        },
        icon = {
            Icon(imageVector =  screen.icon , contentDescription="", tint = Color.White)
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,

        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(route = screen.route){
                popUpTo(navController.graph.findStartDestination().id)
            }
        }
    )
}