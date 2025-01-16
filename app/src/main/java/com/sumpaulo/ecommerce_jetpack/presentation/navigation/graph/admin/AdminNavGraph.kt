package com.sumpaulo.ecommerce_jetpack.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.Graph
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.graph.profile.ProfileNavGraph
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.admin.AdminScreen

import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.product.list.AdminProductListScreen

import com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.info.ProfileScreen


@Composable
fun AdminNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route= Graph.ADMIN,
        startDestination= AdminScreen.ProductList.route,
    ){
        composable(route = AdminScreen.ProductList.route){
            AdminProductListScreen()
        }

        composable(route = AdminScreen.CategoryList.route){
            AdminCategoryListScreen()
        }

        composable(route = AdminScreen.Profile.route){
            ProfileScreen(navController = navController)
        }

        ProfileNavGraph(navController)
    }
}