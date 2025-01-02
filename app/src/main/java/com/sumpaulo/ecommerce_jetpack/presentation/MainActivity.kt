package com.sumpaulo.ecommerce_jetpack.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.graph.RootNavGraph
import com.sumpaulo.ecommerce_jetpack.presentation.ui.theme.EcommercejetpackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcommercejetpackTheme {
                navController = rememberNavController()
                RootNavGraph(navController = navController)
            }
        }
    }
}
