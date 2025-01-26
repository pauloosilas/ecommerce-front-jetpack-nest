package com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create

import DefaultTopBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create.components.AdminCategoryCreateContent
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create.components.CreateCategory
import com.sumpaulo.ecommerce_jetpack.presentation.ui.theme.Gray200

@Composable
fun AdminCategoryCreateScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nova Categoria",
                upAvailable = true,
                navController = navController
            )
        },
    containerColor = Gray200
    ) {
        AdminCategoryCreateContent(paddingValues = it)
    }

    CreateCategory()
}