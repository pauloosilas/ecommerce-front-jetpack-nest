package com.sumpaulo.ecommerce_jetpack.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.Graph
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.AuthScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.Home.HomeScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.login.LoginScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }

        composable(route = AuthScreen.Register.route){
            RegisterScreen(navController)
        }

        composable(route = AuthScreen.Home.route){
            HomeScreen(navController)
        }
    }
}