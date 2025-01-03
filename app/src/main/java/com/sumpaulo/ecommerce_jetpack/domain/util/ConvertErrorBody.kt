package com.sumpaulo.ecommerce_jetpack.domain.util

import android.util.Log
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.sumpaulo.ecommerce_jetpack.domain.model.ErrorResponse
import okhttp3.ResponseBody

object ConvertErrorBody {
    fun convert(errorBody: ResponseBody?): ErrorResponse?{
    return try {
      errorBody?.source()?.let{
          val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
          val moshiAdapter = moshi.adapter(ErrorResponse::class.java)
          moshiAdapter.fromJson(it)
      }
    }catch(e: Exception){
        Log.d("ConvertErrorBody", "Error " + e.message)
        null
    }
    }
}