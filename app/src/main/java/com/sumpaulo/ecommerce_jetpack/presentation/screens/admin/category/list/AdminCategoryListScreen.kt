package com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.list.components.AdminCategoryListContent

@Composable
fun AdminCategoryListScreen(){
    Scaffold() {
        AdminCategoryListContent(paddingValues = it)
    }
}