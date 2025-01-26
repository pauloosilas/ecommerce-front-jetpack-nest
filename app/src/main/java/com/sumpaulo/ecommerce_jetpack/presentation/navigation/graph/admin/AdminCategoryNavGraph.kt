package com.sumpaulo.ecommerce_jetpack.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.Graph
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.admin.AdminCategoryScreen
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create.AdminCategoryCreateScreen


fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ){
        composable(route = AdminCategoryScreen.CategoryCreate.route){
            AdminCategoryCreateScreen(navController)
        }
    }
}