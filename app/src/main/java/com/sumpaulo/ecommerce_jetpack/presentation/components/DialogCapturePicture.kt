package com.sumpaulo.ecommerce_jetpack.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DialogCapturePicture(
    state: MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit
){
    if(state.value) {
        AlertDialog(


            onDismissRequest = {
                state.value = false
            },

            title = {
                Text(text = "Selecione uma opção")
            },

            confirmButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 30.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        modifier = Modifier
                            .width(130.dp),
                        onClick = {
                            state.value = false
                            pickImage()
                        }
                    ) {
                        Text(text = "Galeria")
                    }

                    Button(
                        modifier = Modifier
                            .width(130.dp),
                        onClick = {
                            state.value = false
                            takePhoto()
                        }
                    ) {
                        Text(text = "Camera")
                    }
                }
            },
            dismissButton = {

            }
        )
    }
}