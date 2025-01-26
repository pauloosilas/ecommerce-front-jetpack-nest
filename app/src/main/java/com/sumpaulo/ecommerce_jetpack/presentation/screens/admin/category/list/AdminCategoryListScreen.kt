package com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.list

import DefaultTopBar
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.Graph
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.list.components.AdminCategoryListContent

@Composable
fun AdminCategoryListScreen(navController: NavHostController){

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = {
                    navController.navigate(route = Graph.ADMIN_CATEGORY)
                },
                containerColor = Color.DarkGray) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }){
        AdminCategoryListContent(paddingValues = it)
    }
}