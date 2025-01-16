package com.sumpaulo.ecommerce_jetpack.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.Graph
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.graph.profile.ProfileNavGraph
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.client.ClientScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.client.category.list.ClientCategoryListScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.client.products.list.ClientProductListScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.info.ProfileScreen


@Composable
fun ClientNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route= Graph.CLIENT,
        startDestination= ClientScreen.ProductList.route,
    ){
        composable(route = ClientScreen.ProductList.route){
            ClientProductListScreen()
        }

        composable(route = ClientScreen.CategoryList.route){
            ClientCategoryListScreen()
        }

        composable(route = ClientScreen.Profile.route){
            ProfileScreen(navController = navController)
        }

        ProfileNavGraph(navController)

    }
}