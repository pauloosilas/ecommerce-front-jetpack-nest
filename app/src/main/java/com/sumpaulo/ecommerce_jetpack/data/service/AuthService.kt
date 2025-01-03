package com.sumpaulo.ecommerce_jetpack.data.service

import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
    @FormUrlEncoded
    suspend fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ) : Response<AuthResponse>
}