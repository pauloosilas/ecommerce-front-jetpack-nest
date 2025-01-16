package com.sumpaulo.ecommerce_jetpack.presentation.navigation.graph.roles

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.Graph

import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.roles.RolesScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.home.AdminHomeScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.client.home.ClientHomeScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.rols.RolesScreen


fun NavGraphBuilder.RolesNavGraph(navController: NavHostController){
    navigation(
        route= Graph.ROLES,
        startDestination= RolesScreen.Roles.route,
    ){
        composable(route = RolesScreen.Roles.route){
            RolesScreen(navController)
        }


        composable(route = Graph.CLIENT){
            ClientHomeScreen()
        }

        composable(route = Graph.ADMIN){
            AdminHomeScreen()
        }
    }
}