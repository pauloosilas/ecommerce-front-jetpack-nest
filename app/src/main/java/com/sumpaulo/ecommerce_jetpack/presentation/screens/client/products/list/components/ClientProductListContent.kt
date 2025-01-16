package com.sumpaulo.ecommerce_jetpack.presentation.screens.client.products.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClientProductListContent(paddingValues: PaddingValues){
    Text(
        modifier = Modifier.padding(top=50.dp),
        text = "Product List"
    )
}