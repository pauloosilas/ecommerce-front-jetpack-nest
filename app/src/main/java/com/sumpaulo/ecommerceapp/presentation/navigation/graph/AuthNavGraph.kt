package com.sumpaulo.ecommerceapp.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sumpaulo.ecommerceapp.presentation.navigation.Graph
import com.sumpaulo.ecommerceapp.presentation.navigation.screen.AuthScreen
import com.sumpaulo.ecommerceapp.presentation.screns.auth.login.LoginScreen
import com.sumpaulo.ecommerceapp.presentation.screns.auth.register.RegisterScreen

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
    }
}