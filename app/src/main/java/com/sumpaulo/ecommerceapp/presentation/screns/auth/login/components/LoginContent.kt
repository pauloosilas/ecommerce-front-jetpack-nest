package com.sumpaulo.ecommerceapp.presentation.screns.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sumpaulo.ecommerceapp.R
import com.sumpaulo.ecommerceapp.presentation.components.DefaultButton
import com.sumpaulo.ecommerceapp.presentation.components.DefaultTextField
import com.sumpaulo.ecommerceapp.presentation.navigation.screen.AuthScreen
import com.sumpaulo.ecommerceapp.presentation.screns.auth.login.LoginViewModel


@Composable
fun LoginContent(navController: NavHostController, paddingValues: PaddingValues, viewModel: LoginViewModel = hiltViewModel()){

    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = viewModel.errorMessage){
        if(viewModel.errorMessage != ""){
            Toast.makeText(context,viewModel.errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize().padding(paddingValues)){
        Image(
            modifier = Modifier
                .fillMaxSize()
                .height(200.dp)
                .width(150.dp),
            painter=painterResource(id = R.drawable.banner),
            contentDescription="Imagem de fundo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.5f,0.5f,0.5f,1f)
                }
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.shopping_cart_blue),
                contentDescription = "Logo"
            )
            Text("ECOMMERCE APP",
                modifier = Modifier.padding(top = 7.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier
                    .height(330.dp)
                    .fillMaxSize(),

                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.7f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                        .verticalScroll(rememberScrollState())
                ){
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text="ENTRAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value= state.email,
                        onValueChange = {
                            viewModel.onEmailInput(it)
                        },
                        label = "Email",
                        icon = Icons.Default.Email
                        )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value= state.password,
                        onValueChange = {
                            viewModel.onPasswordInput(it)
                        },
                        label = "Senha",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )

                    DefaultButton(
                        Modifier.fillMaxWidth()
                            .padding(top=20.dp)
                            .height(50.dp),
                        text="LOGIN",
                        onClick = {
                            viewModel.login()
                        }

                        )

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                    ){
                        Text(text="Não tem uma conta?")
                        Spacer(modifier = Modifier.width(6.dp))

                        Text(text="Registre-se",
                            modifier = Modifier.clickable{navController.navigate(route = AuthScreen.Register.route)},
                            color = Color.Blue)
                    }

                }
            }
        }
    }
}
