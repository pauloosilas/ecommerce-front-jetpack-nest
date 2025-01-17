package com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.sumpaulo.ecommerce_jetpack.presentation.components.DefaultTextField
import com.sumpaulo.ecommerce_jetpack.presentation.components.DialogCapturePicture
import com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun ProfileUpdateContent(navController:NavHostController, paddingValues: PaddingValues, viewModel: ProfileUpdateViewModel = hiltViewModel()){
    val activity = LocalContext.current as? Activity
    val state = viewModel.state
    val stateDialog = remember { mutableStateOf(false) }

    viewModel.resultActivityHandler.handle()

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { viewModel.takePhoto() },
        pickImage = { viewModel.pickImage() }
    )

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
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

            if(!state.image.isNullOrBlank()){
                AsyncImage(
                    modifier = Modifier
                        .padding(top=40.dp)
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .clickable{ stateDialog.value = true},
                    model = state.image,
                    contentDescription="",
                    contentScale = ContentScale.Crop
                )
            }else{
                Image(
                    modifier = Modifier
                        .padding(top=40.dp)
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .clickable{ stateDialog.value = true},
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
                       Text(
                           modifier = Modifier.padding(bottom = 20.dp),
                           text="Atualizar",
                           fontSize = 20.sp,
                           color = Color.Black
                       )
                       DefaultTextField(
                           modifier = Modifier.fillMaxWidth(),
                           value = state.name,
                           onValueChange = { viewModel.onNameInput(it)},
                           label = "Nome",
                           icon = Icons.Default.Person
                       )

                       DefaultTextField(
                           modifier = Modifier.fillMaxWidth(),
                           value = state.lastname,
                           onValueChange = {viewModel.onLastnameInput(it)},
                           label = "Sobrenome",
                           icon = Icons.Outlined.Person
                       )

                       DefaultTextField(
                           modifier = Modifier.fillMaxWidth(),
                           value = state.phone,
                           onValueChange = { viewModel.onPhoneInput(it)},
                           label = "Telefone",
                           icon = Icons.Default.Person
                       )

                       Spacer(modifier = Modifier.height(40.dp))
                       DefaultButton(
                           modifier = Modifier.fillMaxWidth(),
                           text="Confirmar",
                           onClick = {viewModel.update()}
                       )
                   }
                }

        }
    }
}

