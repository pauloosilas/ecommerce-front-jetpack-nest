package com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register.mapper

import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.presentation.screens.auth.register.RegisterState

fun RegisterState.toUser() : User{
   return User(
       name = name,
       lastname = lastname,
       email = email,
       phone = phone,
       password = password
    )
}