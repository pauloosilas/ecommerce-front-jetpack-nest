package com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update.mapper

import com.sumpaulo.ecommerce_jetpack.domain.model.User
import com.sumpaulo.ecommerce_jetpack.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser():User{
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}