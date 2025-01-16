package com.sumpaulo.ecommerce_jetpack.presentation.screens.rols.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.sumpaulo.ecommerce_jetpack.domain.model.Rol
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.Graph

@Composable
fun RolesItem(navController:NavHostController, rol: Rol){
    Log.d("ROLA", rol.route.toString())
    Column(modifier = Modifier.clickable{
        navController.navigate(route = rol.route){
          //  popUpTo(route = Graph.ROLES) { inclusive = true}
        }
    }) {
        AsyncImage(
            modifier = Modifier.
            height(150.dp)
                .width(150.dp),
            model = rol.image,
            contentDescription=""
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text=rol.name.uppercase(),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp)

    }

}