package com.sumpaulo.ecommerce_jetpack.presentation.components


import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.sumpaulo.ecommerce_jetpack.presentation.ui.theme.Blue500


@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value:String) -> Unit,
    label:String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false
){
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { text ->
            onValueChange(text)
        },
        label = {
            Text(text=label)
        },
        leadingIcon = {
            Icon(imageVector= icon,
                contentDescription=label,
                tint= Blue500
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType),

        visualTransformation = if(hideText) PasswordVisualTransformation() else VisualTransformation.None
    )
}
