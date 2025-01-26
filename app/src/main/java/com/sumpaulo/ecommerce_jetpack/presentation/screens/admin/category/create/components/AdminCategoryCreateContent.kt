package com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.sumpaulo.ecommerce_jetpack.R
import com.sumpaulo.ecommerce_jetpack.presentation.components.DefaultButton
import com.sumpaulo.ecommerce_jetpack.presentation.components.DefaultTextField
import com.sumpaulo.ecommerce_jetpack.presentation.components.DialogCapturePicture
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create.AdminCategoryCreateViewModel

@Composable
fun AdminCategoryCreateContent(paddingValues: PaddingValues, viewModel: AdminCategoryCreateViewModel = hiltViewModel()) {

    val state = viewModel.state
    viewModel.resultActivityHandler.handle()
    val stateDialog = remember { mutableStateOf(false) }

    DialogCapturePicture(
      state = stateDialog,
      takePhoto = { viewModel.takePhoto() },
      pickImage = { viewModel.pickImage() }
    )

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

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

            )
        }else{
            Image(
                modifier = Modifier
                    .padding(top=40.dp)
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable{ stateDialog.value = true},
                painter =  painterResource(id = R.drawable.image_add),
                contentDescription = "",
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
        Card(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 20.dp),
                    text="CATEGORIA",
                    fontSize = 20.sp,
                    color = Color.Black
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.name,
                    onValueChange = { viewModel.onNameInput(it) },
                    label = "Nome da Categoria",
                    icon = Icons.Default.List
                )

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.description,
                    onValueChange = { viewModel.onDescriptionInput(it) },
                    label = "Descrição",
                    icon = Icons.Outlined.Info
                )


                Spacer(modifier = Modifier.height(40.dp))
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text="CRIAR CATEGORIA",
                    onClick = {
                        viewModel.createCategory()
                    }
                )
            }
        }
    }
}