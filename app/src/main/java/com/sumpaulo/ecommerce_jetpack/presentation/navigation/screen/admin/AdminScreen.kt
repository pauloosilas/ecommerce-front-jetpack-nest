package com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route: String,
    val title:String,
    val icon: ImageVector){

    object CategoryList: AdminScreen(
        route = "admin/category/list",
        title = "Categorias",
        icon = Icons.Default.List
    )

    object ProductList: AdminScreen(
        route = "admin/product/list",
        title = "Produtos",
        icon = Icons.Default.ThumbUp
    )

    object Profile: AdminScreen(
        route = "adin/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )




}