package com.sumpaulo.ecommerceapp.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("phone") val password: String,
    @SerializedName("image") val image: String? = null,
    @SerializedName("notification_token") val notificationToken: String? = null
    ){
    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data:String): User = Gson().fromJson(data, User::class.java)
    }
}