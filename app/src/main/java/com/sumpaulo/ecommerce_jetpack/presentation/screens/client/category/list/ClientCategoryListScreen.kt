package com.sumpaulo.ecommerce_jetpack.presentation.screens.client.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.sumpaulo.ecommerce_jetpack.presentation.screens.client.category.list.components.ClientCategoryListContent

@Composable
fun ClientCategoryListScreen(){
    Scaffold() {
        ClientCategoryListContent(paddingValues = it)
    }
}