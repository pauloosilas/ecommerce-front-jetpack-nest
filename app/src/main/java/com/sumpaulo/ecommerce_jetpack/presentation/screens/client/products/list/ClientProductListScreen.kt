package com.sumpaulo.ecommerce_jetpack.presentation.screens.client.products.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.sumpaulo.ecommerce_jetpack.presentation.screens.client.products.list.components.ClientProductListContent

@Composable
fun ClientProductListScreen(){
    Scaffold() {
        ClientProductListContent(paddingValues = it)
    }
}