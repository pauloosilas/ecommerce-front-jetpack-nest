package com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.info.components

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

import com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.info.ProfileViewModel
import com.sumpaulo.ecommerce_jetpack.R
import com.sumpaulo.ecommerce_jetpack.presentation.MainActivity
import com.sumpaulo.ecommerce_jetpack.presentation.components.DefaultButton
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.Graph
import com.sumpaulo.ecommerce_jetpack.presentation.navigation.screen.profile.ProfileScreen

@Composable
fun ProfileContent(paddingValues: PaddingValues, navController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()){
    val activity = LocalContext.current as? Activity

    Log.d("USER",viewModel.user?.toJson().toString())

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .padding(bottom = 30.dp),
        ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.profile_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.6f,0.6f, 0.6f, 1f)
                }
            ),

        )

        Column(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 20.dp, top = 20.dp),
                onClick = {
                    viewModel.logout()
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }
            ){
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "",
                    tint = Color.White

                )
            }

            if(!viewModel.user?.image.isNullOrBlank()){
                AsyncImage(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    model = viewModel.user?.image,
                    contentDescription="",
                    contentScale = ContentScale.Crop
                )
            }else{
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter =  painterResource(id = R.drawable.user_image),
                    contentDescription = "",
                 )
            }


            Spacer(modifier = Modifier.weight(1f))

            Card(modifier = Modifier
                .fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.7f)
                )
                ) {
                   Column(
                       modifier = Modifier
                           .padding(20.dp)
                   ) {
                       Row(modifier = Modifier
                           .fillMaxWidth()
                           .padding(top = 15.dp),
                           verticalAlignment = Alignment.CenterVertically){
                           Icon(
                               imageVector = Icons.Default.Person,
                               contentDescription = ""
                           )
                           Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                               Text(text= "${viewModel.user?.name} ${viewModel.user?.lastname} ")
                               Text(text = "Nome de Usuário",
                                   fontSize = 12.sp,
                                   color = Color.Gray)
                           }
                       }

                       Row(modifier = Modifier
                           .fillMaxWidth()
                           .padding(top = 15.dp),
                           verticalAlignment = Alignment.CenterVertically){
                           Icon(
                               imageVector = Icons.Default.Email,
                               contentDescription = ""
                           )
                           Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                               Text(text= "${viewModel.user?.email}")
                               Text(text = "Email",
                                   fontSize = 12.sp,
                                   color = Color.Gray)
                           }
                       }

                       Row(modifier = Modifier
                           .fillMaxWidth()
                           .padding(top = 15.dp),
                           verticalAlignment = Alignment.CenterVertically){
                           Icon(
                               imageVector = Icons.Default.Person,
                               contentDescription = ""
                           )
                           Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                               Text(text="${viewModel.user?.phone}")
                               Text(text = "Telefone",
                                   fontSize = 12.sp,
                                   color = Color.Gray)
                           }
                       }
                       Spacer(modifier = Modifier.height(40.dp))
                       DefaultButton(
                           modifier = Modifier.fillMaxWidth(),
                           text="Atualizar informações",
                           onClick = {
                              navController.navigate(route = Graph.PROFILE + "/${viewModel.user?.toJson()}")
                           }
                       )
                   }
                }

        }
    }
}

