package com.sumpaulo.ecommerce_jetpack.presentation.screens.rols.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sumpaulo.ecommerce_jetpack.presentation.screens.rols.RolesViewModel

@Composable
fun RolesContent(paddingValues: PaddingValues, navController: NavHostController, viewModel: RolesViewModel = hiltViewModel()){

    val data = viewModel.authResponse.user

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = data?.roles ?: arrayListOf()
        ){ rol ->
            Spacer(modifier = Modifier.height(20.dp))
            RolesItem(navController, rol = rol)
        }
    }
}