package com.sumpaulo.ecommerce_jetpack.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.Graph
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.profile.ProfileScreen

import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.roles.RolesScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.home.AdminHomeScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.client.home.ClientHomeScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update.ProfileUpdateScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.rols.RolesScreen


fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController){
    navigation(
        route= Graph.PROFILE+"/{user}",
        startDestination= ProfileScreen.ProfileUpdate.route,
    ){
        composable(route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })){
            it.arguments?.getString("user")?.let{
                ProfileUpdateScreen(navController)
            }

        }
    }
}